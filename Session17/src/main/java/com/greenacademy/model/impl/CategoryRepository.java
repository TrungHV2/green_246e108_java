package com.greenacademy.model.impl;

import com.greenacademy.entity.Book;
import com.greenacademy.entity.Category;
import com.greenacademy.model.Pageable;
import com.greenacademy.model.Repository;
import com.greenacademy.util.MySqlConnection;
import com.greenacademy.util.MySqlProvider;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements Repository<Category, Integer> {
    @Override
    public List<Category> findAll() {
        String sql = "SELECT * FROM Categories";
        return MySqlProvider.execute(sql, Category::build);
    }

    @Override
    public Pageable<Category> pagination(int page, int pageSize) {
        List<Category> categories = new ArrayList<>();
        int totalPages = 0;
        try (Connection conn = MySqlConnection.getConnect()) {
            CallableStatement cs = conn.prepareCall("{CALL sp_categories_pagination(?,?,?)}");
            cs.setInt(1, page);
            cs.setInt(2, pageSize);
            cs.registerOutParameter(3, Types.INTEGER);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Category category = Category.build(rs);
                categories.add(category);
            }
            totalPages = cs.getInt(3);
            Pageable<Category> pageable = new Pageable<>(categories, page, pageSize, totalPages);
            return pageable;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
