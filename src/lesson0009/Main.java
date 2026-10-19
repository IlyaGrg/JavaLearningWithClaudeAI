package lesson0009;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Repository<String, String> value = new InMemoryRepository<>();
        value.save("RUB", "Российский рубль");
        tests();
        Repository<AccountNumber, BankAccount> repository = new InMemoryRepository<>();
        //repository.save("BANK121212", new BankAccount("Ilya", 121212)); src/lesson0009/Main.java:14: error: incompatible types: String cannot be converted to AccountNumber
        //        repository.save("BANK121212", new BankAccount("Ilya", 121212));
        //                        ^
        //Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
        //1 error
        //ошибка из-за неверного типа данных

        //Repository<String, int> repository1 = new InMemoryRepository<>();
        //src/lesson0009/Main.java:21: error: unexpected type
        //        Repository<String, int> repository1 = new InMemoryRepository<>();
        //                           ^
        //  required: reference
        //  found:    int
        //1 error
        //должен быть Integer


        List raw = new ArrayList();
        raw.add("Чай");
        raw.add(250);
        String s = (String) raw.get(1);
        //Exception in thread "main" java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')
        //	at lesson0009.Main.main(Main.java:34)
        //сыртой тип дает скомпилировать, но компилятор предупреждает, что используется сырой тип, и на моменте работы программы все ложится из за приведения не к тому типу данных
    }

    static void check(String message, boolean condition) {
        if (condition) {
            System.out.println("ОК: " + message);
        } else {
            System.out.println("ОШИБКА: " + message);
        }
    }

    static void tests(){
        AccountNumber firstAccount = new AccountNumber("BANK40817-001");
        AccountNumber secondAccount = new AccountNumber("BANK40817-001");
        AccountNumber qwerty = new AccountNumber("BANK-2");
        SavingsAccount valeriaSavingAccount = new SavingsAccount("Valeria", 123_222, 50,  120_000);
        AccountNumber valeriaNumber = new AccountNumber("BANK4-09-12");

        BankAccount ilyaAccount = new BankAccount("Ilya", 120_000);
        BankAccount valeriaAccount = new BankAccount("Valeria", 123_123);

        Bank sberBank = new Bank();
        sberBank.openAccount(secondAccount, ilyaAccount);
        int firstSizeOf = sberBank.getAccounts().count();
        sberBank.openAccount(valeriaNumber, valeriaSavingAccount);

        check("Два new AccountNumber(BANK40817-001) равны по equals, но не по ==", (firstAccount.equals(secondAccount)) && firstAccount != secondAccount);

        check("hashCode двух AccountNumber совпадают", firstAccount.hashCode() == secondAccount.hashCode());//hashCode двух номеров не совпадает потому что мы не переопределили hashCode и работает его версия из Object

        check("bank.findAccount(new AccountNumber(BANK40817-001)) находит счёт, открытый с другим объектом того же номера.", sberBank.findAccount(firstAccount) == ilyaAccount);//теперь он считает firstAccount и secondAccount не равными по хешу

        Set<AccountNumber> accounts = new HashSet<>();
        accounts.add(firstAccount);
        accounts.add(secondAccount);
        check("Set<AccountNumber> с двумя одинаковыми номерами имеет размер 1", accounts.size() == 1);//HashSet вызывает HashCode и сверяет по нему,если хеш разный, то это будет считаться как два разных элемента

        check("equals(null) возвращает false, а не бросает исключение", !firstAccount.equals(null));

        Set<BankAccount> userAccounts = new HashSet<>();

        boolean thrown = false;
        try {
            sberBank.findAccount(qwerty);
        } catch (AccountNotFoundException e) {
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


        int lastSizeOf = sberBank.getAccounts().count();

        check("Счетчик count растет", lastSizeOf > firstSizeOf && lastSizeOf == 2);

        sberBank.deleteUser(firstAccount);
        check("deleteById удаляет элемент", sberBank.getAccounts().count() == 1);


        AccountNumber newNumber = new AccountNumber("BANK-122");
        thrown = false;
        try{
            sberBank.findAccount(newNumber);
        } catch (AccountNotFoundException e){
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
        check("Ождиаемое значение: 1000", CollectionUtils.max(nums) == 1000);
        check("Ожидаемое значение: пиццерия", CollectionUtils.max(strings).equals("пиццерия"));
        System.out.println(CollectionUtils.max(strings));
    }

}