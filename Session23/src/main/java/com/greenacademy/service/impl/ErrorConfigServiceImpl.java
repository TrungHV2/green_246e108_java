package com.greenacademy.service.impl;

import com.greenacademy.model.entity.ErrorConfigEntity;
import com.greenacademy.repository.ErrorConfigRepository;
import com.greenacademy.service.ErrorConfigService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ErrorConfigServiceImpl implements ErrorConfigService {
    private final ErrorConfigRepository errorConfigRepository;

    @Override
    public List<ErrorConfigEntity> findAll() {
        return errorConfigRepository.findAll();
    }
}
