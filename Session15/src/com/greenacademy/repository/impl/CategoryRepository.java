package com.greenacademy.repository.impl;

import com.greenacademy.entity.CategoryEntity;
import com.greenacademy.repository.Repository;
import com.greenacademy.util.MySqlProvider;

import java.util.List;

public class CategoryRepository implements Repository<CategoryEntity, Integer> {
    @Override
    public List<CategoryEntity> findAll() {
        String sql = "SELECT * FROM Categories";
        return MySqlProvider.execute(sql, CategoryEntity::build);
    }

    @Override
    public List<CategoryEntity> pagination(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        String sql = "SELECT * FROM Categories ORDER BY id LIMIT ? OFFSET ?";
        return MySqlProvider.execute(sql, CategoryEntity::build, pageSize, offset);
    }

    @Override
    public CategoryEntity findById(Integer id) {
        String sql = "SELECT * FROM Categories WHERE id=?";
        return MySqlProvider.execute(sql, CategoryEntity::build, id).getFirst();
    }

    @Override
    public CategoryEntity save(CategoryEntity categoryEntity) {
        String sql = "INSERT INTO Categories(name) VALUES (?)";
        int cateId = MySqlProvider.update(sql, categoryEntity.getCategoryName());
        if (cateId > 0) {
            categoryEntity.setCategoryId(cateId);
            return categoryEntity;
        }
        return null;
    }

    @Override
    public boolean update(CategoryEntity categoryEntity) {
        String sql = "UPDATE Categories SET name=? WHERE id=?";
        int result = MySqlProvider.update(sql, categoryEntity.getCategoryName(), categoryEntity.getCategoryId());
        return result > 0;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM Categories WHERE id=?";
        int result = MySqlProvider.update(sql, id);
        return result > 0;
    }
}
