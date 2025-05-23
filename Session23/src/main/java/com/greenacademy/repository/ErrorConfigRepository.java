package com.greenacademy.repository;

import com.greenacademy.model.entity.ErrorConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorConfigRepository extends JpaRepository<ErrorConfigEntity, String> {
}
