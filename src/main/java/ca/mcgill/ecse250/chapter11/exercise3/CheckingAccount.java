package ca.mcgill.ecse250.chapter11.exercise3;

import ca.mcgill.ecse250.chapter09.Account;

public class CheckingAccount extends Account {
    private double overdraftLimit;
    public CheckingAccount() {
        super();
    }

    public CheckingAccount(int id, double balance, double annualInterestRate, double overdraftLimit) {
        super(id, balance, annualInterestRate);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "overdraftLimit=" + overdraftLimit +
                ","  + super.toString()
                + '}';
    }
}
