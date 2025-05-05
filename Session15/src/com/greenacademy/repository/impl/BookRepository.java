package com.greenacademy.repository.impl;

import com.greenacademy.entity.BookEntity;
import com.greenacademy.repository.Repository;

import java.util.List;

public class BookRepository implements Repository<BookEntity, String> {
    @Override
    public List<BookEntity> findAll() {
        //MySqlProvider.execute("SELECT * FROM Books");
        return List.of();
    }

    @Override
    public List<BookEntity> pagination(int page, int pageSize) {
        return List.of();
    }

    @Override
    public BookEntity findById(String id) {
        //MySqlProvider.execute("SELECT * FROM Books WHERE bookId=?", id);
        return null;
    }

    @Override
    public BookEntity save(BookEntity bookEntity) {
        return null;
    }

    @Override
    public boolean update(BookEntity bookEntity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
