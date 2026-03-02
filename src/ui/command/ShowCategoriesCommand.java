package ui.command;

import entity.Category;
import service.CategoryService;
import util.ConsolePrinter;

import java.util.List;

public record ShowCategoriesCommand(CategoryService categoryService) implements Command {

    @Override
    public String choice() {
        return "3";
    }

    @Override
    public void process() {
        List<Category> allCategories = categoryService.getAllCategories();
        if (ConsolePrinter.printList(allCategories, "Не має категорій")) {
            return;
        }
        ConsolePrinter.showList(allCategories, "----- КАТЕГОРІЇ -----");
    }
}
