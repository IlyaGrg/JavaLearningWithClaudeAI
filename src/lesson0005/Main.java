package lesson0005;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount("Илья", 10_000));
        accounts.add(new BankAccount("Валерия", 10_000));
        accounts.add(new SavingsAccount("Тильзу", 10_000, 12, 3_000));

        for (BankAccount account : accounts) {
            System.out.println(account);
        }

        for (BankAccount account : accounts) {
            try {
                account.withdraw(5000);

            } catch (ExceedingTheLimit e) {
                System.out.println("Вы пытаетесь снять: " + e.getAmount() + " при лимите в " + e.getMaxWithdrawal());
            }
        }//с накопительного счета не удалось снять 3000 потому что сработало переопределение метода withdraw(), которое гласит, что нельзя снять сумму, большую maxWithdrawal, в нашем случае 3000, а мы пытались снять 5000 из-за этого вылезло исключение, мы его поймали и объявили, что снять сумму нельзя по правилам.
        //accounts.get(1).addInterest();
        //src/lesson0005/Main.java:24: error: cannot find symbol
        //        accounts.get(1).addInterest();
        //                       ^
        //  symbol:   method addInterest()
        //  location: class BankAccount
        //1 error
        //Ошибка произошла из-за полиморфизма, т.к все элементы массива имеют тип данных BankAccount, то именно этот класс определяет какие методы можно использовать, а какая версия выполнится, решает уже тип объекта.
        //Т.к мы пытаемся вызвать метод addInterest(), которого нет в классе BankAccount компилятор не дает запустить программу. Он выдает ошибку location class BankAccount
        //Потому что не нашел такого метода в этом классе
        SavingsAccount savingIlyaAccount = new SavingsAccount("Илья", 10_000, 12, 10_000);
        savingIlyaAccount.addInterest();
        System.out.println(savingIlyaAccount.getBalance());
        //Я думаю перевод не пройдет, так как в transerTo() используется withdraw() который уже был переопределен в SavingsAccount.
        //Так как здесь тип данных у переменной SavingsAccount, то методы можно использовать такие, какие есть в SavingsAccount(в том числе и в его родителе)
        SavingsAccount savings = new SavingsAccount("Илья", 10_000, 5, 3000);
        BankAccount other = new BankAccount("Валерия", 0);
        savings.transferTo(other, 4000);
        //Exception in thread "main" lesson0005.ExceedingTheLimit: Нельзя снять сумму 4000 это превышает лимит в 3000
        //	at lesson0005.SavingsAccount.withdraw(SavingsAccount.java:37)
        //	at lesson0005.BankAccount.transferTo(BankAccount.java:48)
        //	at lesson0005.Main.main(Main.java:41)
        //соответственно я был прав. Вылезло исключение, так как мы не ловили его в  try/catch
    }


}