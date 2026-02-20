package service.impl;

import entity.Category;
import repository.CategoryRepository;
import service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> all = categoryRepository.getAll();
        if(all.isEmpty()) {
            throw new IllegalArgumentException("Список категорії пустий");
        }
        return all;
    }

    @Override
    public void createCategory(Category category) {
        if(category == null) {
            throw new IllegalArgumentException("Введіть коректні дані!");
        }
        categoryRepository.saveCategory(category);
    }
}
