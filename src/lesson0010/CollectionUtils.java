package lesson0010;

import java.util.List;

public class CollectionUtils {
    public static <T> T firstOrThrow(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Список пуст");
        }
        return list.get(0);
    }

    //src/lesson0009/CollectionUtils.java:16: error: cannot find symbol
//            if (item.compareTo(best) < 0){
//                    ^
//  symbol:   method compareTo(T)
//  location: variable item of type T
//  where T is a type-variable:
//    T extends Object declared in method <T>max(List<T>)
//1 error
    //extends Comparable<T> позволяет вызывать метод только для сравнимых элементов. Так как мы вызываем compareTo в методе, программа не компилируется
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
//Проверка связи