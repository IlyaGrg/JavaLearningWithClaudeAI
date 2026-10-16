package lesson0008;

public class Main {
    public static void main(String[] args){
        AccountNumber firstAccounts = new AccountNumber("BANK40817-001");
        AccountNumber secondAccounts = new AccountNumber("BANK40817-001");
        check("Два new AccountNumber(BANK40817-001) равны по equals, но не по ==" , (firstAccounts.equals(secondAccounts)) && firstAccounts != secondAccounts);
        check("hashCode двух AccountNumber совпадают", firstAccounts.hashCode() == secondAccounts.hashCode());
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