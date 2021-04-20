package com.product.catalog.service;

import com.product.catalog.model.Category;
import com.product.catalog.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {

        return categoryRepository.save(category);
    }

    public void saveAll(List<Category> category) {

         categoryRepository.saveAll(category);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

}
