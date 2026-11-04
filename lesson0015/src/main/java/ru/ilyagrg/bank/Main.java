package ru.ilyagrg.bank;

public class Main {
    public static void main(String[] args){
        Bank bank = new Bank();
        AccountNumber accountNumber = new AccountNumber("BANK-4110");
        AccountNumber accountNumber1 = new AccountNumber("BANK-4111");

        BankAccount bankAccount = new BankAccount("Adam", 100_000);
        SavingsAccount bankAccount1 = new SavingsAccount("Ilya", 123_000, 20, 40_000);
        bank.openAccount(accountNumber, bankAccount);
        bank.openAccount(accountNumber1, bankAccount1);

        System.out.println("Adam: " + bankAccount.getBalance());
        System.out.println("Ilya: " + bankAccount1.getBalance());

        bank.transfer(accountNumber, accountNumber1, 51_126);
        System.out.println("Перевод от Adam к Ilya...");
        System.out.println("Adam: " + bankAccount.getBalance());
        System.out.println("Ilya: " + bankAccount1.getBalance());

    }
}