package lesson0002;

import java.util.ArrayList;

public class Shop {
    public static void main(String[] args) {
        ArrayList<Product> cart = new ArrayList<>();
        ArrayList<Product> emptyCart = new ArrayList<>();
        cart.add(new Product("Специи", 50, 13));
        cart.add(new Product("Порошок для белья", 651, 5));
        cart.add(new Product("Magsafe air battery pack", 11000, 0));
        System.out.println("Сумма корзины: " + cartTotal(cart));
        Product theMostExpensiveProduct = findMostExpensive(emptyCart);
        if (theMostExpensiveProduct== null) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(theMostExpensiveProduct.price);
        }

        theMostExpensiveProduct = findMostExpensive(cart);
        if (theMostExpensiveProduct== null) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(theMostExpensiveProduct.price);
        }

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
        System.out.println(cart.get(0));
        for (Product product : cart) {
            System.out.println(product.toString());
        }
        Product copy = cart.get(0);
        copy.price = 1;
        System.out.println(cart.get(0));//copy обращается к той же ссылке, что и cart[0] потому при изменении copy мыменяем и cart[0]
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