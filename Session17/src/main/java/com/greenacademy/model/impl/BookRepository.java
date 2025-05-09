package com.greenacademy.model.impl;

import com.greenacademy.entity.Book;
import com.greenacademy.model.Pageable;
import com.greenacademy.model.Repository;
import com.greenacademy.util.MySqlProvider;

import java.util.List;

public class BookRepository implements Repository<Book, String> {
    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM Books";
        return MySqlProvider.execute(sql, Book::build);
    }

    @Override
    public Pageable<Book> pagination(int page, int pageSize) {
        return null;
    }

    @Override
    public Book findById(String id) {
        String sql = "SELECT * FROM Books WHERE bookId = ?";
        return MySqlProvider.execute(sql, Book::build, id).get(0);
    }

    @Override
    public Book save(Book book) {
        String sql = "INSERT INTO Books(bookId, bookName, author, categoryId, price) VALUES (?,?,?,?,?)";
        Object[] params = new Object[] {
                book.getBookId(),
                book.getBookName(),
                book.getAuthor(),
                book.getCategoryId(),
                book.getPrice()
        };
        int cateId = MySqlProvider.update(sql, params);
        if (cateId > 0) {
            book.setCategoryId(cateId);
            return book;
        }
        return null;
    }

    @Override
    public boolean update(Book book) {
        String sql = "UPDATE Books SET bookName=?,author=?,categoryId=?,price=? WHERE bookId=?";
        Object[] params = new Object[] {
                book.getBookName(),
                book.getAuthor(),
                book.getCategoryId(),
                book.getPrice(),
                book.getBookId()
        };
        int result = MySqlProvider.update(sql, params);
        return result > 0;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM Books WHERE bookId=?";
        int result = MySqlProvider.update(sql, id);
        return result > 0;
    }
}
