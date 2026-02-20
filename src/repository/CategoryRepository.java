package repository;

import entity.Category;

import java.util.List;

public interface CategoryRepository {

    void saveCategory(Category category);

    Category getCategory(String name);

    List<Category> getAll();
}
