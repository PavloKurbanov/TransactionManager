package entity;

import java.util.Objects;

public record Category(String name) {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}
