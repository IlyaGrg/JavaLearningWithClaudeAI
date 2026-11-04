package ru.ilyagrg.bank;

import java.util.List;

public class CollectionUtils {
    public static <T> T firstOrThrow(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Список пуст");
        }
        return list.get(0);
    }

    public static <T extends Comparable<T>> T max(List<T> list) {
        T best = firstOrThrow(list);
        for (T item : list) {
            if (item.compareTo(best) > 0) {
                best = item;
            }
        }
        return best;
    }
}
