package ui.command;

import entity.Category;
import ui.io.InputReader;
import service.CategoryService;

public class AddCategoryCommand implements Command {
    private final CategoryService categoryService;
    private final InputReader inputReader;

    public AddCategoryCommand(CategoryService categoryService, InputReader inputReader) {
        this.categoryService = categoryService;
        this.inputReader = inputReader;
    }

    @Override
    public String choice() {
        return "2";
    }

    @Override
    public void process() {
        try {
            String categoryName = inputReader.readString("Введіть назву категорії: ");
            categoryService.createCategory(new Category(categoryName));
            System.out.println("Категорію " + categoryName + " створено");
            ;
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА: " + e.getMessage());
        }
    }
}
