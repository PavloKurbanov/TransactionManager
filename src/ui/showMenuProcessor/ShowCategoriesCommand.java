package ui.showMenuProcessor;

import ui.command.Command;
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
        try {
            List<Category> allCategories = categoryService.getAllCategories();
            System.out.println("----- КАТЕГОРІЇ -----");
            for (Category category : allCategories) {
                System.out.println(category);
            }
        }  catch (IllegalArgumentException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }
}
