package lesson0008;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        AccountNumber firstAccount = new AccountNumber("BANK40817-001");
        AccountNumber secondAccount = new AccountNumber("BANK40817-001");
        BankAccount ilyaAccount = new BankAccount("Ilya", 120_000);
        BankAccount valeriaAccount = new BankAccount("Valeria", 123_123);
        Bank sberBank = new Bank();
        sberBank.openAccount(secondAccount, ilyaAccount);
        check("Два new AccountNumber(BANK40817-001) равны по equals, но не по ==" , (firstAccount.equals(secondAccount)) && firstAccount != secondAccount);
        check("hashCode двух AccountNumber совпадают", firstAccount.hashCode() == secondAccount.hashCode());//hashCode двух номеров не совпадает потому что мы не переопределили hashCode и работает его версия из Object
        check("bank.findAccount(new AccountNumber(BANK40817-001)) находит счёт, открытый с другим объектом того же номера.", sberBank.findAccount(firstAccount) == sberBank.findAccount(secondAccount));//теперь он считает firstAccount и secondAccount не равными по хешу
        Set<AccountNumber> accounts = new HashSet<>();
        accounts.add(firstAccount);
        accounts.add(secondAccount);
        check("Set<AccountNumber> с двумя одинаковыми номерами имеет размер 1", accounts.size() == 1);//HashSet вызывает HashCode и сверяет по нему,если хеш разный, то это будет считаться как два разных элемента
        check("equals(null) возвращает false, а не бросает исключение", !firstAccount.equals(null));
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
    }

    static void check(String message, boolean condition){
        if (condition){
            System.out.println("ОК: " + message);
        }
        else{
            System.out.println("ОШИБКА: " + message);
        }
    }
}