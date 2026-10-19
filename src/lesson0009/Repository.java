package lesson0009;

import java.util.List;

public interface Repository<T, ID> {
    void save(ID id, T item);

    T findById(ID id);

    boolean existsById(ID id);

    List<T> findAll();

    int count();

    void deleteById(ID id);
}