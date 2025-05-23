package com.greenacademy.service.impl;

import com.greenacademy.exception.ErrorCode;
import com.greenacademy.exception.GreenException;
import com.greenacademy.model.BookRequest;
import com.greenacademy.model.BookResponse;
import com.greenacademy.repository.BookRepository;
import com.greenacademy.service.BookService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<BookResponse> findAll() {
        LOGGER.info("[START] BookServiceImpl findAll");
        try {
            List<BookResponse> responses = bookRepository.findAll().stream()
                .map(x -> modelMapper.map(x, BookResponse.class))
                .collect(Collectors.toList());
            LOGGER.info("[END] BookServiceImpl findAll success {}", responses);
            return responses;
        } catch (Exception ex) {
            LOGGER.error("[EXCEPTION] BookServiceImpl findAll exception {}", ex);
            throw new GreenException(ErrorCode.SYSTEM_ERROR);
        }
    }

    @Override
    public BookResponse findId(String id) {
        return null;
    }

    @Override
    public BookResponse save(BookRequest book) {
        return null;
    }
}
