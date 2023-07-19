package com.example.restapi.bookmanagementnew.service;
import jakarta.validation.Valid;
import com.example.restapi.bookmanagementnew.dto.BookDTO;
import com.example.restapi.bookmanagementnew.entity.Book;
import com.example.restapi.bookmanagementnew.mapper.BookMapper;
import com.example.restapi.bookmanagementnew.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            return bookMapper.toDTO(book);
        }
        else {
            throw new IllegalArgumentException("Book not found with ID: " + id);
        }
    }

    public BookDTO addBook(@Valid BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDTO(savedBook);
    }

    public BookDTO updateBook(Long id, @Valid BookDTO bookDTO) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(bookDTO.getTitle());
            existingBook.setAuthor(bookDTO.getAuthor());
            existingBook.setIsbn(bookDTO.getIsbn());
            existingBook.setPublicationDate(bookDTO.getPublicationDate());
            Book updatedBook = bookRepository.save(existingBook);
            return bookMapper.toDTO(updatedBook);
        }
        else {
            throw new IllegalArgumentException("Book not found with ID: " + id);
        }
    }

    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("Book not found with ID: " + id);
        }
    }
}
