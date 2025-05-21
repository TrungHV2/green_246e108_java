package com.greenacademy.service.impl;

import com.greenacademy.entity.BookEntity;
import com.greenacademy.model.BookResponse;
import com.greenacademy.repository.BookRepository;
import com.greenacademy.service.BookService;
import org.hibernate.query.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<BookResponse> findBy(String name, String author, Double price) {
        Specification<BookEntity> spec = Specification.where(null);
        if (name != null) {
            spec = spec.and((r, c, b) -> b.like(r.get("bookName"), "%" +name+ "%"));
        }
        if (author != null) {
            spec = spec.and((r, c, b) -> b.like(r.get("author"), "%" +author+ "%"));
        }
        if (price != null) {
            spec = spec.and((r, c, b) -> b.equal(r.get("price"), price));
        }
        // Phân trang
        //Pageable pageable = PageRequest.of(0, 10, Sort.by("price").descending());
        //Page<BookEntity> page = bookRepository.findAll(spec, pageable);
        List<BookResponse> responses = bookRepository.findAll(spec)
                .stream()
                .map(x -> modelMapper.map(x, BookResponse.class))
                .collect(Collectors.toList());

        return responses;
    }
}
