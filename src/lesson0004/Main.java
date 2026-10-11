package lesson0004;

public class Main {
    public static void main(String[] args) {
        BankAccount userBankAccount = new BankAccount("User", 1000);
        int[] requests = {300, 5000, -100, 200};

        for (int request : requests) {
            try {
                userBankAccount.withdraw(request);
                System.out.println("Выдано " + request + ", осталось " + userBankAccount.getBalance());
            } catch (InsufficientFundsException e) {
                System.out.println("Не хватает " + (e.getRequested() - e.getAvailable()));

            } catch (IllegalArgumentException e) {
                System.out.println("Неверная сумма: " + e.getMessage());
            }
        }
        System.out.println("Банкомат закрыт.");
        System.out.println("Баланс: " + userBankAccount.getBalance());
        BankAccount ilyaBankAccount = new BankAccount("Ilya", 13_000);
        BankAccount valeriaBankAccount = new BankAccount("Valeria", 12_000);

        try {
            ilyaBankAccount.transferTo(valeriaBankAccount, 13_001);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(ilyaBankAccount.getBalance());
        System.out.println(valeriaBankAccount.getBalance());
        //балансы не изменились потому что мы корректно использовали методы withdraw(), deposit() в методе transferTo() и потому при ошибке не происходит лишнего перевода, то есть мы сначала проверяли на корекктность и только потом переводили, если бы была ошибка, то вылетело бы исключение и ложный перевод бы не состоялся

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
        }//catch нельзя менять местами потому что IllegalArgumentException родитель NumberFormatException
        //Все что вывел компилятор у меня совпало. В случае с x печатается 1 A 3 5(1 печатается всегда A напечаталось, но не напечаталось B потому что int n = Integer.parseInt(s); невозможно x перевести в int, затем сработало исключение NumberFormatException и напечаталось 3, 5 печатается всегда после try/catch
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