package lesson0013;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        tests();

        BankAccount newIlyaAccount = new BankAccount("Ilya", 123_123);
        SavingsAccount newIlyaSavingsAccount = new SavingsAccount("Ilya", 100_000, 10, 100_000);
        BankAccount newValeriaAccount = new BankAccount("Valeria", 100_000);
        BankAccount adamAccount = new BankAccount("Adam", 1_000_000);
        AccountNumber ilyaNumber = new AccountNumber("BANK-123");
        AccountNumber valeriaNumber = new AccountNumber("BANK-1234");
        AccountNumber ilyaSavingsNumber = new AccountNumber("BANK-12345");
        AccountNumber adamNumber = new AccountNumber("BANK-ADAM");
        Bank tBank = new Bank();
        tBank.openAccount(ilyaNumber, newIlyaAccount);
        tBank.openAccount(valeriaNumber, newValeriaAccount);
        tBank.openAccount(ilyaSavingsNumber, newIlyaSavingsAccount);

        int ilyaBalance = tBank.balanceByOwner().get("Ilya");
        check("balanceByOwner правильно считает баланс для пользователя с двумя счетами", ilyaBalance == 123_123 + 100_000);
        check("accountsByOwner работает корректно", tBank.accountsByOwner().get("Valeria").size() == 1 && tBank.accountsByOwner().get("Ilya").size() == 2);
        List<BankAccount> sortedAccountListByBalance = tBank.sortedByBalanceDesc();
        boolean flag = true;
        for (int i = 0; i < sortedAccountListByBalance.size() - 1; i++) {
            if (sortedAccountListByBalance.get(i).getBalance() < sortedAccountListByBalance.get(i + 1).getBalance()) {
                flag = false;
            }
        }
        check("sortedByBalanceDesc работает правильно", flag);

        List<BankAccount> sortedAccountListByOwner = tBank.sortedByOwner();
        flag = true;
        for (int i = 0; i < sortedAccountListByOwner.size() - 1; i++) {
            BankAccount firstUser = sortedAccountListByOwner.get(i);
            BankAccount secondUser = sortedAccountListByOwner.get(i + 1);
            if (firstUser.getOwner().compareTo(secondUser.getOwner()) > 0) {
                flag = false;
            }
            if (firstUser.getOwner().equals(secondUser.getOwner()) && firstUser.getBalance() > secondUser.getBalance()) {
                flag = false;
            }
        }
        check("sortedByOwner правильно работает", flag);
        int N = 101_000;


        List<BankAccount> allAccounts = tBank.findAccounts(acc -> acc.getBalance() > N);


        check("findAccounts от лямбды с балансом работает корректно", allAccounts.stream().allMatch(acc -> acc.getBalance() > N) && allAccounts.size() != 0);
        allAccounts = tBank.findAccounts(acc -> acc.getOwner().equals("Ilya"));


        check("findAccounts от лямбды с владельцем работает корректно", allAccounts.stream().allMatch(acc -> acc.getOwner().equals("Ilya")) && allAccounts.size() != 0 );
        check("sortedByOwner правильно работает", sortedAccountListByOwner.get(0).getOwner().equals("Ilya") && sortedAccountListByOwner.get(2).getOwner().equals("Valeria") && sortedAccountListByOwner.get(1).getBalance() == 123_123);
        check("sortedByBalanceDesc работает правильно", sortedAccountListByBalance.get(0).getBalance() == 123_123 && sortedAccountListByBalance.get(0).getOwner().equals("Ilya") && sortedAccountListByBalance.size() == 3);
        check("totalBalance работает исправно", tBank.totalBalance() == newIlyaAccount.getBalance() + newIlyaSavingsAccount.getBalance() + newValeriaAccount.getBalance());
        check("owners работает исправно", tBank.owners().contains("Valeria") && tBank.owners().contains("Ilya") && tBank.owners().size() == 2);
        tBank.openAccount(adamNumber, adamAccount);

        List<String> richest = tBank.richOwners(100_000);
        check("richOwners работает исправно", richest.get(0).equals("Adam") && richest.get(1).equals("Ilya") && richest.size() == 3);
        check("countAccounts работает исправно", tBank.countAccounts(acc -> acc.getBalance() > 101_000 && acc.getOwner().equals("Ilya")) == 1 && tBank.countAccounts(acc -> acc.getOwner().equals("Ilya")) == 2);

        Stream<String> s = List.of("a", "b").stream().filter(x -> { System.out.println("проверяю " + x); return true; });
        s.count();



    }

    static void check(String message, boolean condition) {
        if (condition) {
            System.out.println("ОК: " + message);
        } else {
            System.out.println("ОШИБКА: " + message);
        }
    }

    static void tests() {
        AccountNumber firstAccount = new AccountNumber("BANK40817-001");
        AccountNumber secondAccount = new AccountNumber("BANK40817-001");
        AccountNumber qwerty = new AccountNumber("BANK-2");
        SavingsAccount valeriaSavingAccount = new SavingsAccount("Valeria", 123_222, 50, 120_000);
        AccountNumber valeriaNumber = new AccountNumber("BANK4-09-12");

        BankAccount ilyaAccount = new BankAccount("Ilya", 120_000);
        BankAccount valeriaAccount = new BankAccount("Valeria", 123_123);

        Bank sberBank = new Bank();
        sberBank.openAccount(secondAccount, ilyaAccount);
        int firstSizeOf = sberBank.getCount();
        sberBank.openAccount(valeriaNumber, valeriaSavingAccount);

        check("Два new AccountNumber(BANK40817-001) равны по equals, но не по ==", (firstAccount.equals(secondAccount)) && firstAccount != secondAccount);

        check("hashCode двух AccountNumber совпадают", firstAccount.hashCode() == secondAccount.hashCode());

        check("bank.findAccount(new AccountNumber(BANK40817-001)) находит счёт, открытый с другим объектом того же номера.", sberBank.findAccount(firstAccount) == ilyaAccount);

        Set<AccountNumber> accounts = new HashSet<>();
        accounts.add(firstAccount);
        accounts.add(secondAccount);
        check("Set<AccountNumber> с двумя одинаковыми номерами имеет размер 1", accounts.size() == 1);

        check("equals(null) возвращает false, а не бросает исключение", !firstAccount.equals(null));


        boolean thrown = false;
        try {
            sberBank.findAccount(qwerty);
        } catch (EntityNotFoundByIdException e) {
            thrown = true;
        }
        check("findAccount() от некорректного значения", thrown);

        thrown = false;

        try {
            sberBank.openAccount(null, ilyaAccount);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        check("openAccount от некорректного number", thrown);

        thrown = false;
        try {
            sberBank.openAccount(firstAccount, null);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        check("openAccount от некорректного account", thrown);

        thrown = false;
        try {
            sberBank.openAccount(secondAccount, valeriaAccount);
        } catch (DuplicateAccountException e) {
            thrown = true;
        }
        check("Открытие счёта с занятым номером бросает исключение ", thrown);


        int lastSizeOf = sberBank.getCount();

        check("Счетчик count растет", lastSizeOf > firstSizeOf && lastSizeOf == 2);

        sberBank.deleteUser(firstAccount);
        check("deleteById удаляет элемент", sberBank.getCount() == 1);


        AccountNumber newNumber = new AccountNumber("BANK-122");
        thrown = false;
        try {
            sberBank.findAccount(newNumber);
        } catch (EntityNotFoundByIdException e) {
            thrown = true;
        }
        check("findById неверного ID вызывает исключение", thrown);
        List<Integer> emptyList = new ArrayList<>();
        thrown = false;
        try {
            CollectionUtils.max(emptyList);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        check("max от пустого списка бросает исключение", thrown);

        List<Integer> nums = List.of(10, 20, -100, 12, 1000);
        List<String> strings = List.of("яблоко", "груша", "пиццерия");
        check("Ожидаемое значение: 1000", CollectionUtils.max(nums) == 1000);
        check("Ожидаемое значение: яблоко", CollectionUtils.max(strings).equals("яблоко"));


        Repository<String, String> value = new InMemoryRepository<>();
        value.save("RUB", "Российский рубль");
        int firstCount = value.count();

        value.save("USD", "Доллар США");
        check("Ожидается: Российский рубль", value.findById("RUB").equals("Российский рубль"));
        check("count растет", value.count() == firstCount + 1);
        check("existsById для существующего ID", value.existsById("RUB"));
        check("existsById для несуществующего ID", !value.existsById("SDRUB"));
        thrown = false;
        try {
            value.findById("REB");
        } catch (EntityNotFoundByIdException e) {
            thrown = true;
        }
        check("findById несуществующего ID бросает исключение", thrown);

    }

}