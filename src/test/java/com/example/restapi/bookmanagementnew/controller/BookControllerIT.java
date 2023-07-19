package com.example.restapi.bookmanagementnew.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerIT {

String str= """
		{
		"id": 1,
		"title": "Book 1",
		"author": "Author 1",
		"isbn": "ISBN-1",
		"publicationDate": "2023-07-18"
		}
		""";
private static String BOOK_URL="/books/1";
@Autowired
private TestRestTemplate template;
	@Test
	void getAllBooks() {
	ResponseEntity<String>responseEntity= template.getForEntity(BOOK_URL,String.class);
	System.out.println(responseEntity.getBody());
		System.out.println(responseEntity.getHeaders());
	}

}
