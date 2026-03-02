package repository.impl;

import entity.Category;
import repository.CategoryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryRepositoryImpl implements CategoryRepository {
    private final Map<String, Category> categories;

    public CategoryRepositoryImpl() {
        this.categories = new HashMap<>();
    }

    @Override
    public void saveCategory(Category category) {
        categories.put(category.getName(), category);
    }

    @Override
    public Category getCategory(String name) {
        return categories.get(name);
    }

    @Override
    public List<Category> getAll() {
        return new ArrayList<>(categories.values());
    }
}
