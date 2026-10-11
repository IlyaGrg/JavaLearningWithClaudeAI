package lesson0004;

public class Main {
    public static void main(String[] args) {
        BankAccount userBankAccount = new BankAccount("User", 1000);
        int[] requests = {300, 5000, -100, 200};

        for (int request : requests) {
            try {
                userBankAccount.withdraw(request);
                System.out.println("Выдано " + request + " осталось " + userBankAccount.getBalance());
            } catch (InsufficientFundsException e) {
                System.out.println("Не хватает " + (e.getRequested() - e.getAvailable()));

            } catch (IllegalArgumentException e) {
                System.out.println("Неверная сумма " + e.getMessage());
            }
        }
        System.out.println("Банкомат закрыт.");

        BankAccount ilyaBankAccount = new BankAccount("Ilya", 13_000);
        BankAccount valeriaBankAccount = new BankAccount("Valeria", 12_000);

        try {
            ilyaBankAccount.transferTo(valeriaBankAccount, 13_001);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(ilyaBankAccount.getBalance());
        System.out.println(valeriaBankAccount.getBalance());
        //балансы не изменились потому что мы корректно использовали методы withdraw(), deposit() в методе transferTo() и потому при ошибке не происходит лишнего перевода

        String[] inputs = {"7", "x", "-2"};
        for (String s : inputs) {
            try {
                System.out.println("1");
                int n = parsePositive(s);
                System.out.println("2 " + n);
            } catch (NumberFormatException e) {
                System.out.println("3");
            } catch (IllegalArgumentException e) {
                System.out.println("4 " + e.getMessage());
            }
            System.out.println("5");
        }//catch нельзя менять местами потому что IlleagalArgumentException родитель NumberFormatException
    }

    static int parsePositive(String s) {
        System.out.println("A");
        int n = Integer.parseInt(s);
        System.out.println("B");
        if (n <= 0) {
            throw new IllegalArgumentException("не положительное: " + n);
        }
        System.out.println("C");
        return n;
    }


}