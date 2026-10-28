package lesson0013;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T, ID> implements Repository<T, ID> {
    private Map<ID, T> memory = new HashMap<>();

    public void save(ID id, T item) {
        if (id == null || item == null) {
            throw new IllegalArgumentException("Некорректные данные");
        }
        memory.put(id, item);
    }

    public T findById(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("Некорректные данные");
        }
        if (memory.containsKey(id)) {
            return memory.get(id);
        } else {
            throw new EntityNotFoundByIdException("По такому ID ничего не найдено: " + id);
        }
    }

    public boolean existsById(ID id) {
        return (id != null && memory.containsKey(id));
    }

    public List<T> findAll() {
        return new ArrayList<>(memory.values());
    }

    public int count() {
        return memory.size();
    }

    public void deleteById(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("Некорректные данные");
        }
        if (!memory.containsKey(id)) {
            throw new EntityNotFoundByIdException("По такому ID невозможно удалить: " + id);
        } else {
            memory.remove(id);
        }
    }
}