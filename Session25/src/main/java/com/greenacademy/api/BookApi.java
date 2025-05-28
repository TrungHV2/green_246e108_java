package com.greenacademy.api;

import com.greenacademy.model.BookRequest;
import com.greenacademy.model.BookResponse;
import com.greenacademy.service.BookService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
@CrossOrigin("*")
public class BookApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookApi.class);

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<?> get() {
        LOGGER.info("[START] BookApi get");
        List<BookResponse> data = bookService.findAll();
        LOGGER.info("[END] BookApi get");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') || hasRole('SHIPPER')")
    public ResponseEntity<?> post(@RequestBody BookRequest bookRequest) {
        LOGGER.info("[START] BookApi post");
        BookResponse response = bookService.save(bookRequest);
        LOGGER.info("[END] BookApi post");
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}