package ca.mcgill.ecse250.chapter09;

import java.util.Date;

public class Account {
    private static final double MONTHS_IN_YEAR = 12.0;

    private int id = 0;
    private double balance = 0.0;
    private double annualInterestRate = 0.0;
    private Date dateCreated = new Date();
    public Account() {}
    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public double getMonthlyInterestRate() {
        return  balance * annualInterestRate / MONTHS_IN_YEAR;
    }
    public double withdraw(int amount) {
        if (balance < amount) {
            return 0.0;
        }
        balance -= amount;
        return amount;

    }
    public void deposit(int amount) {
        if(amount < 0) {
            return;
        }
        balance += amount;
    }
}
