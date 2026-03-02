package repository.fileImpl;

import entity.Category;
import repository.CategoryRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FIleCategoryRepository implements CategoryRepository {
    private final Path filePath;
    private final Map<String, Category> categories;

    public FIleCategoryRepository(Path filePath) {
        this.filePath = filePath;
        this.categories = new HashMap<>();
        try{
            if(!Files.exists(filePath)) {
                Files.createFile(filePath);
            } else {
                loadFile();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveCategory(Category category) {
        categories.put(category.name(), category);
        try{
            saveFile();
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category getCategory(String name) {
        return categories.get(name);
    }

    @Override
    public List<Category> getAll() {
        return new ArrayList<>(categories.values());
    }

    private void saveFile() throws IOException {
        List<String> lines = new ArrayList<>();
        for (Category category : categories.values()) {
            String categoryName = category.name();
            lines.add(categoryName);
        }
        Files.write(filePath, lines);
    }

    private void loadFile() throws IOException {
        boolean exists = Files.exists(filePath);
        if (!exists) {
            return;
        }
        List<String> list = Files.readAllLines(filePath);

        for (String category : list) {
            Category categoryObject = new Category(category);
            categories.put(categoryObject.name(), categoryObject);
        }
    }
}
