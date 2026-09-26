package ca.mcgill.ecse250.chapter11.exercise3;

import ca.mcgill.ecse250.chapter09.Account;

public class SavingsAccount extends Account {

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(int id, double balance, double annualInterestRate) {
        super(id, balance, annualInterestRate);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" + super.toString() + "}";
    }
}
