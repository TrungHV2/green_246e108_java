package com.greenacademy.api;

import com.greenacademy.model.request.CategoryRequest;
import com.greenacademy.model.response.CategoryResponse;
import com.greenacademy.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(value = {"*"})
@RequestMapping("/api/category")
public class CategoryApi {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> list() {
        return categoryService.findAll();
    }
    @GetMapping("/search")
    public List<CategoryResponse> search(@RequestParam String name) {
        return categoryService.findByName(name);
    }
    @GetMapping("/{id}")
    public CategoryResponse get(@PathVariable Integer id) {
        return categoryService.findById(id);
    }
    @PostMapping
    public CategoryResponse save(@RequestBody CategoryRequest category) {
        return categoryService.save(category);
    }
    @PutMapping
    public CategoryResponse update(@RequestBody CategoryRequest category) {
        return categoryService.save(category);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return categoryService.delete(id);
    }
}
