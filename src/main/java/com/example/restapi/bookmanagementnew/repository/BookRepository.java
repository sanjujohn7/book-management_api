package com.example.restapi.bookmanagementnew.repository;

import com.example.restapi.bookmanagementnew.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
