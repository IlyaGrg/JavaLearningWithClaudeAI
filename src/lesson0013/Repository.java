package lesson0013;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {
    void save(ID id, T item);

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    List<T> findAll();

    int count();

    void deleteById(ID id);
}