package lesson0008;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        AccountNumber firstAccount = new AccountNumber("BANK40817-001");
        AccountNumber secondAccount = new AccountNumber("BANK40817-001");
        AccountNumber qwerty = new AccountNumber("BANK-2");
        SavingsAccount valeriaSavingAccount = new SavingsAccount("Valeria", 123_222, 50,  120_000);
        AccountNumber valeriaNumber = new AccountNumber("BANK4-09-12");

        BankAccount ilyaAccount = new BankAccount("Ilya", 120_000);
        BankAccount valeriaAccount = new BankAccount("Valeria", 123_123);

        Bank sberBank = new Bank();
        sberBank.openAccount(secondAccount, ilyaAccount);
        sberBank.openAccount(valeriaNumber, valeriaSavingAccount);

        check("Два new AccountNumber(BANK40817-001) равны по equals, но не по ==", (firstAccount.equals(secondAccount)) && firstAccount != secondAccount);
        //первый тест проходит потому что срабатывает equals(AccountNumber)
        check("hashCode двух AccountNumber совпадают", firstAccount.hashCode() == secondAccount.hashCode());//hashCode двух номеров не совпадает потому что мы не переопределили hashCode и работает его версия из Object
        //второй тест проходит потому что есть метод hashCode()
        check("bank.findAccount(new AccountNumber(BANK40817-001)) находит счёт, открытый с другим объектом того же номера.", sberBank.findAccount(firstAccount) == ilyaAccount);//теперь он считает firstAccount и secondAccount не равными по хешу
        //падает третий тест потому что bank это MAP а HashMap ищет по версии Object
        Set<AccountNumber> accounts = new HashSet<>();
        accounts.add(firstAccount);
        accounts.add(secondAccount);
        check("Set<AccountNumber> с двумя одинаковыми номерами имеет размер 1", accounts.size() == 1);//HashSet вызывает HashCode и сверяет по нему,если хеш разный, то это будет считаться как два разных элемента
        //падает 4 тест потому что в HashSet сравнивается по equals(Object)
        check("equals(null) возвращает false, а не бросает исключение", !firstAccount.equals(null));
        //можно передать null как AccountNumber поэтому срабатывает ветка if (o == null)
        Set<BankAccount> userAccounts = new HashSet<>();
        userAccounts.add(ilyaAccount);
        ilyaAccount.deposit(1111);
        //System.out.println(userAccounts.contains(ilyaAccount));false. После депозита hashCode считает по другому balance. Из-за этого не находит


        Integer a = 100, b = 100, c = 500, d = 500;
        String s1 = "банк", s2 = "банк", s3 = new String("банк");
        System.out.println(a == b);//true
        System.out.println(c == d);//false(>127)
        System.out.println(c.equals(d));//true
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1.equals(s3));//true


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

    }

    static void check(String message, boolean condition) {
        if (condition) {
            System.out.println("ОК: " + message);
        } else {
            System.out.println("ОШИБКА: " + message);
        }
    }
}