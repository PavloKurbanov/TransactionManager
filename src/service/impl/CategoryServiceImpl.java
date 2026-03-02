package service.impl;

import entity.Category;
import repository.CategoryRepository;
import service.CategoryService;

import java.util.List;

public record CategoryServiceImpl(CategoryRepository categoryRepository) implements CategoryService {

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAll();
    }

    @Override
    public void createCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Введіть коректні дані!");
        }
        categoryRepository.saveCategory(category);
    }
}
