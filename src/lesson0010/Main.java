package lesson0010;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Repository<String, String> value = new InMemoryRepository<>();
        value.save("RUB", "Российский рубль");
        int firstCount = value.count();

        value.save("USD", "Доллар США");
        tests();
        check("Ожидается: Российский рубль", value.findById("RUB").equals("Российский рубль"));
        check("count растет", value.count() == firstCount + 1);
        check("existsById для существующего ID", value.existsById("RUB"));
        check("existsById для несуществующего ID", !value.existsById("SDRUB"));
        boolean thrown = false;
        try {
            value.findById("REB");
        } catch (EntityNotFoundByIdException e){
            thrown = true;
        }
        check("findById несуществующего ID бросает исключение", thrown);
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

    }

}