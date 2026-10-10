package lesson0003;

public class Main {
    public static void main(String[] args) {
        Product iPhone = new Product("IPhone", 110_000, 5);
        Product macBook = new Product("MacBook", 204_500, 2);

        BankAccount ilyaAccount = new BankAccount("Илья", 20_000);
        BankAccount valeriaAccount = new BankAccount("Валерия", 20_000);
        BankAccount scammer = null;

        System.out.println(iPhone.getName() + " " + iPhone.getPrice() + " " + iPhone.getQuantity());
        System.out.println(macBook.getName() + " " + macBook.getPrice()+ " " + macBook.getQuantity());


        iPhone.setPrice(100_000);
        iPhone.applyDiscount(20);
        iPhone.sell(4);
        System.out.println(iPhone.getName() + " " + iPhone.getPrice() + " " + iPhone.getQuantity());

        macBook.setPrice(320_000);
        macBook.applyDiscount(0);
        macBook.addStock(12);

        System.out.println(macBook.getName() + " " + macBook.getPrice()+ " " + macBook.getQuantity());

        System.out.println(ilyaAccount.getOwner() + " " + ilyaAccount.getBalance());
        System.out.println(valeriaAccount.getOwner() + " " + valeriaAccount.getBalance());

        ilyaAccount.deposit(15_000);
        valeriaAccount.withdraw(5_500);
        ilyaAccount.transferTo(valeriaAccount, 35_000);

        System.out.println(ilyaAccount.getOwner() + " " + ilyaAccount.getBalance());
        System.out.println(valeriaAccount.getOwner() + " " + valeriaAccount.getBalance());

        //iPhone.setPrice(-1); Exception in thread "main" java.lang.IllegalArgumentException: Цена не может быть отрицательной: -1
        //iPhone.applyDiscount(101);Exception in thread "main" java.lang.IllegalArgumentException: Скидка может быть предоставлена в отрезке от 0 до 100 процентов, запрошено: 101
        //iPhone.sell(10); Exception in thread "main" java.lang.IllegalArgumentException: Невозможно продать 10 товаров из 1
        //macBook.addStock(-500); Exception in thread "main" java.lang.IllegalArgumentException: Количество поступившего товара должно быть положительно
        //ilyaAccount.deposit(-1000); Exception in thread "main" java.lang.IllegalArgumentException: Сумма пополнения должна быть положительной: -1000
        //valeriaAccount.withdraw(55_000); Exception in thread "main" java.lang.IllegalArgumentException: Нельзя снять отрицательную сумму или сумму, больше чем на счету: 55000
        //valeriaAccount.transferTo(valeriaAccount, 100_000); Exception in thread "main" java.lang.IllegalArgumentException: Нельзя перевести деньги самому себе или несуществующему пользователю.
        //valeriaAccount.transferTo(ilyaAccount, 100_000); Exception in thread "main" java.lang.IllegalArgumentException: Нельзя переводить отрицательную сумму или сумму, больше чем на счету
        //valeriaAccount.transferTo(scammer, 100_000); Exception in thread "main" java.lang.IllegalArgumentException: Нельзя перевести деньги самому себе или несуществующему пользователю.
        //BankAccount loruAccount= new BankAccount("Лору", -1); Exception in thread "main" java.lang.IllegalArgumentException: Баланс на счету не может быть отрицательным: -1
        //Product magSafeAirBatteryPack = new Product("Mag Safe Air Battery Pack", 110_000, -11); Exception in thread "main" java.lang.IllegalArgumentException: Количество товара не может быть отрицательным: -11
        //Product magSafeAirBatteryPack = new Product("                                 ", 110_000, 11); Exception in thread "main" java.lang.IllegalArgumentException: Название товара не может быть пустым или состоять только из пробелов
        //ilyaAccount.balance = 10000000; src/lesson0003/Main.java:49: error: balance has private access in BankAccount
        BankAccount a = new BankAccount("Илья", 1000);
        BankAccount b = a;
        b.withdraw(300);
        System.out.println(a.getBalance());
        //700
    }
}