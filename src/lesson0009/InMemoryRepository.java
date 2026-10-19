package lesson0009;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<ID, T> implements Repository<ID, T> {
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
            throw new AccountNotFoundException("По такому ID ничего не найдено: " + id);
        }
    }

    public boolean existsById(ID id) {
        if (id == null || !memory.containsKey(id)) {
            return false;
        }
        return true;
    }

    public List<T> findAll() {
        List<T> all = new ArrayList<>();
        for (T things : memory.values()) {
            all.add(things);
        }
        return all;
    }

    public int count() {
        return memory.size();
    }

    public void deleteById(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("Некорректные данные");
        }
        if (!memory.containsKey(id)) {
            throw new FindByIdException("По такому ID нельзя невозможно удалить: " + id);
        } else {
            memory.remove(id);
        }

    }


}