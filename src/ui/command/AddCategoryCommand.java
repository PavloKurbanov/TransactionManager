package ui.command;

import entity.Category;
import ui.io.InputReader;
import service.CategoryService;

public record AddCategoryCommand(CategoryService categoryService, InputReader inputReader) implements Command {

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
