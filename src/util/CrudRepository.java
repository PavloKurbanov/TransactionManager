package util;

import java.util.List;

// <T> - це тип сутності (Wallet, Category, Transaction)
// <ID> - це тип ключа (String для назви, Integer для ID)
public interface CrudRepository<T, ID> {

    void save(T entity); // Зберегти будь-що

    T getById(ID id);    // Знайти будь-що за його ключем

    List<T> getAll();    // Отримати список будь-чого
}