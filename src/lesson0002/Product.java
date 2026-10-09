package lesson0002;

public class Product {
    String name;
    int price;
    int quantity;

    Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    int totalCost() {
        return price * quantity;
    }

    boolean isInStock() {
        return quantity > 0;
    }

    void applyDiscount(int percent) {
        price = price - price * percent / 100;
    }
    @Override
    public String toString() {//почему мы делаем public?
        return name + ": " + price + " руб. x " + quantity;
    }
}