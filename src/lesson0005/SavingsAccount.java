package lesson0005;

import lesson0005.BankAccount;

public class SavingsAccount extends BankAccount {
    private int interestRate;
    private int maxWithdrawal;

    public SavingsAccount(String owner, int balance, int interestRate, int maxWithdrawal) {
        //src/lesson0005/SavingsAccount.java:9: error: constructor BankAccount in class BankAccount cannot be applied to given types;
        //    public SavingsAccount(String owner, int balance, int interestRate, int maxWithdrawal) {
        //                                                                                          ^
        //  required: String,int
        //  found:    no arguments
        //  reason: actual and formal argument lists differ in length
        //1 error
        //Если убрать super(owner, balance); то просто напросто не осуществляется конструктор, так как этот класс наследован от другого
        super(owner, balance);
        if (interestRate < 0 || interestRate > 100) {
            throw new IllegalArgumentException("Процент начисления должен быть от 0 до 100: " + interestRate);
        }
        if (maxWithdrawal <= 0) {
            throw new IllegalArgumentException("Максимум должен быть неотрицательным: " + maxWithdrawal);
        }

        this.interestRate = interestRate;
        this.maxWithdrawal = maxWithdrawal;
    }

    public int getInterestRate(){
        return interestRate;
    }

    public int getMaxWithdrawal(){
        return maxWithdrawal;
    }

    public void addInterest(){
        this.deposit(getBalance() * interestRate / 100);
    }
//src/lesson0005/SavingsAccount.java:42: error: method does not override or implement a method from a supertype
//    @Override
//    ^
//1 error
    //Ошибка из-за того, что не понятно зачем стоит @Override если не находися такого же метода в классе родителе
//Лимит тот же
    @Override
    public void withdraw(int amount){
        if (amount > maxWithdrawal){
            throw new ExceedingTheLimit(amount, maxWithdrawal);
        }
    }
    @Override
    public String toString(){
        return super.toString() + " Накопительный счет, " + interestRate + "%";
    }
}