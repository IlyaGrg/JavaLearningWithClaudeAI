package ru.ilyagrg.bank;

public class Main {
    public static void main(String[] args){
        Bank bank = new Bank();
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Adam", 123_000);
        AccountNumber accountNumber1 = new AccountNumber("BANK-4111");
        SavingsAccount bankAccount1 = new SavingsAccount("Ilya", 123_000, 20, 40_000);
        bank.openAccount(n, b);
        bank.openAccount(accountNumber1, bankAccount1);


        BankAccount ilyaAccount = new BankAccount("Ilya", 123_000);
        AccountNumber accountNumber11 = new AccountNumber("BANK-41111");
        bank.openAccount(accountNumber11, ilyaAccount);
        System.out.println(bank.accountsByOwner());
    }
}