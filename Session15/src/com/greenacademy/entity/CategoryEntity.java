package com.greenacademy.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryEntity {
    private int categoryId;
    private String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public static CategoryEntity build(ResultSet rs) throws SQLException {
        CategoryEntity category = new CategoryEntity();
        category.setCategoryId(rs.getInt("id"));
        category.setCategoryName(rs.getString("name"));
        return category;
    }
}
