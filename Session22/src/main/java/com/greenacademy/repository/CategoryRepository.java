package com.greenacademy.repository;

import com.greenacademy.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>, JpaSpecificationExecutor<CategoryEntity> {
    // JPA Query Method
    List<CategoryEntity> findByNameContaining(String name);

    // Java Persistence Query Language
    @Query("select c from CategoryEntity c where c.name like ?1")
    List<CategoryEntity> queryByNameContaining(String name);

    // Native Query
    @Query(value = "select * from Categories where name like :name", nativeQuery = true)
    List<CategoryEntity> nativeQueryByNameContaining(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("update CategoryEntity set name = :name where id = :id")
    int updateCategoryName(String name, int id);
}
