package lesson0006;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ConsoleEmailNotifier emailNotifier = new ConsoleEmailNotifier("LocalBankKazan@gmail.com");
        ConsoleSmsNotifier smsNotifier = new ConsoleSmsNotifier();
        FakeNotifier fakeNotifier = new FakeNotifier();

        TransferService newService = new TransferService(emailNotifier);//Поменял одну строчку smsNotifier на emailNotifier
        TransferService fakeService = new TransferService(fakeNotifier);

        BankAccount ilyaBankAccount = new BankAccount("ilya", 960_000);
        BankAccount tilzuBankAccount = new BankAccount("tilzu", 7_000);
        SavingsAccount ilyaSavingsAccount = new SavingsAccount("ilya", 120_000, 50, 119_000);

        newService.transfer(ilyaBankAccount, tilzuBankAccount, 2_000);
        fakeService.transfer(ilyaBankAccount, tilzuBankAccount, 100);
        int sentCountInService = fakeNotifier.getSentCount();
        if (sentCountInService == 2){
            System.out.println("ОК");
        }else {
            System.out.println("ОШИБКА: Ожидалось 2, получено " + sentCountInService);
        }

        //Notifier n = new Notifier(); src/lesson0006/Main.java:29: error: Notifier is abstract; cannot be instantiated
        //        Notifier n = new Notifier();
        //                     ^
        //1 error


        try{
            fakeService.transfer(ilyaBankAccount, tilzuBankAccount, 100_000_000);
        } catch(InsufficientFundsException e){
            System.out.println(fakeNotifier.getLastMessage());
        }
        System.out.println(fakeNotifier.getSentCount()); //Неудачный перевод он не считает

        ArrayList<BankAccount> accountsArrays = new ArrayList<>();
        accountsArrays.add(ilyaBankAccount);
        accountsArrays.add(tilzuBankAccount);
        accountsArrays.add(ilyaSavingsAccount);
        Collections.sort(accountsArrays);
        System.out.println(accountsArrays);
        //Полиморфизм. Тип переменной определил какие методы можно использовать, а так как SavingsAccount наследуется от BankAccount, он может использовать все методы своего родителя
    }
}