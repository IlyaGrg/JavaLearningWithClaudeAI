package lesson0001;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Shop{
    public static void main(String[] args){
        int[] prices = {45 ,32 , 31, 48, 100, 30, 99};

        System.out.println(findMax(prices));
        System.out.println(averagePrice(prices));
        ArrayList<Integer> Prices = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вводите числа для списка, чтобы закончить, введите 0: ");
        int x = scanner.nextInt();
        while (x != 0){
            Prices.add(x);
            x = scanner.nextInt();
        }
        scanner.close();
        System.out.println(averagePrice(Prices));
        String code = "KZN45a7u";
        System.out.println(isValidPromoCode(code));

        System.out.println(Arrays.toString(prices));
        applyDiscount(prices, 20);
        System.out.println(Arrays.toString(prices));

    }




    static int findMax(int[] prices){
        int maxPrice = prices[0];
        for(int price: prices){
            if (price > maxPrice){
                maxPrice = price;
            }
        }
        return maxPrice;
    }


    static double averagePrice(int[] prices){
        double average = 0;
        for (int price: prices){
            average += price;
        }
        return average / prices.length;
    }


    static double averagePrice(ArrayList<Integer> prices){
        double average = 0;
        for (int price: prices){
            average += price;
        }
        return average / prices.size();
    }


    static boolean isValidPromoCode(String code){
        if (code.substring(0, 3).equals("KZN") && code.length() == 8){
            return true;
        }
        return false;
    }
    static void applyDiscount(int[] prices, int percent){
        for (int i = 0; i < prices.length; i ++){
            prices[i] = prices[i] - ((prices[i] * percent) / 100);
        }
    }
}

///Значения в массиве меняется потому  что в метод передается адрес на массив, в отличие от обычной переменной, даже не смотря на то, что метод void мы все равно меняем исходный массив.
