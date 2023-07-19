package com.example.restapi.bookmanagementnew.mapper;
import com.example.restapi.bookmanagementnew.dto.BookDTO;
import com.example.restapi.bookmanagementnew.entity.Book;
import org.springframework.stereotype.Component;
@Component
public class BookMapper {
    public BookDTO toDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setPublicationDate(book.getPublicationDate());
        return bookDTO;
    }

    public Book toEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setPublicationDate(bookDTO.getPublicationDate());
        return book;
    }
}
