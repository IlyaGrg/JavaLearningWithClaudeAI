package lesson0001;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {


        int[] prices = {45, 32, 31, 48, 100, 30, 99};
        int[] carPrices = {};


        System.out.println("Максимальная цена в prices: " + findMax(prices));
        System.out.println("Максимальная цена в carPrices: " + findMax(carPrices));
        System.out.println("Средняя цена в prices: " + averagePrice(prices));
        System.out.println("Средняя цена в carPrices: " + averagePrice(carPrices));


        ArrayList<Integer> userPrices = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вводите числа для списка, чтобы закончить, введите 0: ");
        int x = scanner.nextInt();
        while (x != 0) {
            userPrices.add(x);
            x = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Средняя цена для userPrices: " + averagePrice(userPrices));


        String code = "KZN45t7u";
        String errorCode = "L1";
        System.out.println("Значение кода: " + isValidPromoCode(code));
        System.out.println("Значение другого кода: " + isValidPromoCode(errorCode));


        System.out.println(Arrays.toString(prices));
        applyDiscount(prices, 20);


        System.out.println(Arrays.toString(prices));

    }


    static int findMax(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxPrice = prices[0];
        for (int price : prices) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;

    }


    static double averagePrice(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        double sum = 0;
        for (int price : prices) {
            sum += price;
        }
        return sum / prices.length;

    }


    static double averagePrice(ArrayList<Integer> prices) {
        if (prices.size() == 0) {
            return 0;
        }
        double sum = 0;
        for (int price : prices) {
            sum += price;
        }
        return sum / prices.size();

    }


    static boolean isValidPromoCode(String code) {
        return (code.length() == 8 && code.startsWith("KZN"));
    }

    static void applyDiscount(int[] prices, int percent) {
        for (int i = 0; i < prices.length; i++) {
            prices[i] = prices[i] - ((prices[i] * percent) / 100);
        }
    }
}

// Значения в массиве меняется потому  что в метод передается адрес на массив, в отличие от обычной переменной, даже не смотря на то, что метод void мы все равно меняем исходный массив.
