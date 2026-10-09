package lesson0002;

import java.util.ArrayList;

public class Shop {
    public static void main(String[] args) {
        ArrayList<Product> cart = new ArrayList<>();
        cart.add(new Product("Специи", 50, 13));
        cart.add(new Product("Порошок для белья", 651, 5));
        cart.add(new Product("Magsafe air battery pack", 11000, 0));
        System.out.println(cartTotal(cart));
        System.out.println(findMostExpensive(cart).price);
        for (Product product : cart) {
            System.out.println("Цена товара " + product.name + " до скидки: " + product.price);
            product.applyDiscount(10);
        }
        for (Product product : cart) {

            if (!product.isInStock()) {
                System.out.println(product.name + " нет в наличии");
            } else {
                System.out.println("Цена товара " + product.name + " после скидки: " + product.price);
            }
        }
        System.out.println(cart.get(0));//теперь для печати i го элемента он применяет метод toString. Скажи, обязательно метод называть именно так и почему мы ставим @Override над методом
        for (Product product : cart) {
           System.out.println(product.toString());
        }

    }

    static Product findMostExpensive(ArrayList<Product> cart) {
        if (cart.size() == 0) {
            return null;
        }
        int max = cart.get(0).price;
        Product theMostExpensiveProduct = null;
        for (Product product : cart) {
            if (product.price >= max) {
                max = product.price;
                theMostExpensiveProduct = product;
            }
        }
        return theMostExpensiveProduct;
    }


    static int cartTotal(ArrayList<Product> cart) {
        int sum = 0;
        for (Product product : cart) {
            sum += product.totalCost();
        }
        return sum;
    }
}