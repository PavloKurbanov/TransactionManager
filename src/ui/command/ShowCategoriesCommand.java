package ui.command;

import entity.Category;
import service.CategoryService;

import java.util.List;

public class ShowCategoriesCommand implements Command {
    private final CategoryService categoryService;

    public ShowCategoriesCommand(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public String choice() {
        return "3";
    }

    @Override
    public void process() {
        List<Category> allCategories = categoryService.getAllCategories();
        if (allCategories.isEmpty()) {
            System.out.println("Не має категорій");
            return;
        }

        System.out.println("----- КАТЕГОРІЇ -----");
        for (Category category : allCategories) {
            System.out.println(category);
        }
    }
}
