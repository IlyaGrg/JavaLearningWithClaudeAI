package lesson0003;

public class Product {
    private String name;
    private int price;
    private int quantity;


    public Product(String name, int price, int quantity) {
        checkName(name);
        this.name = name;

        checkPrice(price);
        this.price = price;

        checkQuantity(quantity);
        this.quantity = quantity;

    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(int price) {
        checkPrice(price);
        this.price = price;
    }

    public void addStock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Количество поступившего товара должно быть положительно");
        }
        quantity = quantity + amount;
    }

    public void sell(int amount) {
        if (amount <= 0 || amount > quantity) {
            throw new IllegalArgumentException("Невозможно продать " + amount + " товаров " + " из " + quantity);
        }
        quantity = quantity - amount;
    }

    public void applyDiscount(int percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Скидка может быть предоставлена в отрезке от 0 до 100 процентов, запрошено: " + percent);
        }
        price = price - price * percent / 100;
    }

    private static void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название товара не может быть пустым или состоять только из пробелов");
        }
    }

    private static void checkPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной: " + price);
        }
    }

    private static void checkQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Количество товара не может быть отрицательным: " + quantity);
        }
    }


    public int totalCost() {

        return price * quantity;
    }

    public boolean isInStock() {

        return quantity > 0;
    }


    @Override
    public String toString() {
        return name + ": " + price + " руб. x " + quantity;
    }
}