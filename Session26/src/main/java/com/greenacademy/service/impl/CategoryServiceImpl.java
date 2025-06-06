package com.greenacademy.service.impl;

import com.greenacademy.domain.CategoryEntity;
import com.greenacademy.exception.ErrorCode;
import com.greenacademy.exception.GreenException;
import com.greenacademy.model.request.CategoryRequest;
import com.greenacademy.model.response.CategoryResponse;
import com.greenacademy.repository.CategoryRepository;
import com.greenacademy.service.CategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableCaching
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    @Cacheable(value = "categories", unless = "#result == null")
    public List<CategoryResponse> findAll() {
        LOGGER.info("[START] CategoryServiceImpl findAll");
        try {
            List<CategoryEntity> categories = categoryRepository.findAll();
            List<CategoryResponse> categoryResponses = categories.stream()
                    .map(category -> modelMapper.map(category, CategoryResponse.class))
                    .collect(Collectors.toList());
            // Thủ công
            // lưu cache
            //redisTemplate.opsForValue().set("categories", categoryResponses);
            // lấy từ bộ nhớ cache
            //redisTemplate.opsForValue().get("categories");
            LOGGER.info("[END] CategoryServiceImpl findAll response={}", categoryResponses);
            return categoryResponses;
        } catch (Exception ex) {
            LOGGER.error("[EXCEPTION] CategoryServiceImpl findAll with ex={0}", ex);
            throw new GreenException(ErrorCode.SYSTEM_ERROR);
        }
    }

    @Override
    @Cacheable(value = "categoriesFindByName", unless = "#result == null")
    public List<CategoryResponse> findByName(String name) {
        LOGGER.info("[START] CategoryServiceImpl findByName={}", name);
        try {
            List<CategoryEntity> categories = categoryRepository.findByNameContaining(name);
            List<CategoryResponse> categoryResponses = categories.stream()
                    .map(category -> modelMapper.map(category, CategoryResponse.class))
                    .collect(Collectors.toList());
            LOGGER.info("[END] CategoryServiceImpl findByName response={}", categoryResponses);
            return categoryResponses;
        } catch (Exception ex) {
            LOGGER.error("[EXCEPTION] CategoryServiceImpl findByName with ex={0}", ex);
            throw new GreenException(ErrorCode.SYSTEM_ERROR);
        }

    }

    @Override
    @Cacheable(value = "category", key = "#id", unless = "#result == null")
    public CategoryResponse findById(Integer id) {
        LOGGER.info("[START] CategoryServiceImpl findById id={}", id);
        try {
            CategoryEntity category = categoryRepository.findById(id).orElse(null);
            CategoryResponse response = category != null ? modelMapper.map(category, CategoryResponse.class) : null;
            LOGGER.info("[END] CategoryServiceImpl findById response={}", response);
            return response;
        } catch (Exception ex) {
            LOGGER.error("[EXCEPTION] CategoryServiceImpl findById with ex={0}", ex);
            throw new GreenException(ErrorCode.SYSTEM_ERROR);
        }

    }

    @Override
    @CacheEvict(value = {"categories", "categoriesFindByName", "category"}, allEntries = true)
    public CategoryResponse save(CategoryRequest category) {
        LOGGER.info("[START] CategoryServiceImpl save request={}", category);
        try {
            CategoryEntity categoryEntity = modelMapper.map(category, CategoryEntity.class);
            categoryEntity = categoryRepository.save(categoryEntity);
            CategoryResponse response = modelMapper.map(categoryEntity, CategoryResponse.class);
            LOGGER.info("[END] CategoryServiceImpl save response={}", response);
            return response;
        } catch (Exception ex) {
            LOGGER.error("[EXCEPTION] CategoryServiceImpl save with ex={0}", ex);
            throw new GreenException(ErrorCode.SYSTEM_ERROR);
        }

    }

    @Override
    @CacheEvict(value = {"categories", "categoriesFindByName"}, allEntries = true)
    public boolean delete(Integer id) {
        LOGGER.info("[START] CategoryServiceImpl delete id={}", id);
        try {
            CategoryEntity category = categoryRepository.findById(id).orElse(null);
            if (category != null) {
                categoryRepository.delete(category);
                LOGGER.info("[END] CategoryServiceImpl delete successfully");
                return true;
            }
            LOGGER.info("[END] CategoryServiceImpl delete failed");
            return false;
        } catch (Exception ex) {
            LOGGER.error("[EXCEPTION] CategoryServiceImpl delete with ex={0}", ex);
            throw new GreenException(ErrorCode.SYSTEM_ERROR);
        }
    }
}
