package lesson0007;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        BankAccount ilyaBankAccount = new BankAccount("Ilya", 20_123);
        BankAccount valeriaBankAccount = new BankAccount("Valeria", 134_124);
        SavingsAccount ilyaSavingsAccount = new SavingsAccount("Ilya", 121_190, 50, 50_000);
        BankAccount tilzuBankAccount = new BankAccount("tilzu", 111_111);
        BankAccount badAccount = new BankAccount("somebody", 10_000);

        Bank sberBank = new Bank();

        sberBank.openAccount("YtR-456", ilyaBankAccount);
        sberBank.openAccount("IuTagJH-12W", valeriaBankAccount);
        sberBank.openAccount("12SX-901", ilyaSavingsAccount);
        sberBank.openAccount("QWSX78-SABUT57-IN1SP", tilzuBankAccount);

        check("Первый тест, owners().size() равен числу разных владельцев", sberBank.owners().size() == 3);
        check("Второй тест, balanceByOwner() для владельца с двумя счетами равен сумме двух балансов", sberBank.balanceByOwner().get("Ilya") == ilyaBankAccount.getBalance() + ilyaSavingsAccount.getBalance());
        check("Проверка работы метода accountsByOwner()", sberBank.accountsByOwner().get("Ilya").size() == 2);
        int balanceBeforeExperiment = sberBank.totalBalance();

        sberBank.transfer("YtR-456", "QWSX78-SABUT57-IN1SP", 1500);

        int balanceAfterExperiment = sberBank.totalBalance();

        check("Третий тест, totalBalance() не изменился после перевода между счетами банка", balanceBeforeExperiment == balanceAfterExperiment);
        boolean thrown = false;
        try {
            sberBank.openAccount("YtR-456", badAccount);
        } catch (DuplicateAccountException e) {
            thrown = true;
        }
        check("Четвертый тест, открытие счёта с занятым номером бросает исключение", thrown);

        thrown = false;
        try {
            sberBank.findAccount("228");
        } catch (AccountNotFoundException e) {
            thrown = true;
        }
        check("Пятый тест, findAccount несуществующего номера бросает исключение", thrown);


//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);

//        for (int number: numbers){
//            numbers.remove(0); Exception in thread "main" java.util.ConcurrentModificationException
//	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
//	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
//	at lesson0007.Main.main(Main.java:63)
//        }

        //List<Integer> numbers = List.of(10, 20, 30);
        //numbers.add(12);
        //Exception in thread "main" java.lang.UnsupportedOperationException
        //	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
        //	at java.base/java.util.ImmutableCollections$AbstractImmutableCollection.add(ImmutableCollections.java:147)
        //	at lesson0007.Main.main(Main.java:60)

        Set<BankAccount> set = new HashSet<>();
        set.add(new BankAccount("Илья", 100));
        set.add(new BankAccount("Илья", 100));
        System.out.println(set.size());
        //2 скорее всего он воспринимает классы как разные несмотря на то, что поля у них одинаковые
        Set<String> names = new HashSet<>();
        names.add(new String("Илья"));
        names.add(new String("Илья"));
        System.out.println(names.size());
        //1
        System.out.println(sberBank.accountsByOwner());
    }

    static void check(String name, boolean condition) {
        if (condition) {
            System.out.println("ОК: " + name);
        } else {
            System.out.println("ОШИБКА: " + name);
        }
    }
}