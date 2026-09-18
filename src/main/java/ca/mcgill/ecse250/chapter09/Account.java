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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getMonthlyInterestRate() {
        return  balance * annualInterestRate / MONTHS_IN_YEAR;
    }
    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Insufficient funds :(");
            return;
        }
        balance -= amount;
    }
    public void deposit(double amount) {
        if(amount < 0.0) {
            System.out.println("You cannot deposit negative amount!!");
            return;
        }
        balance += amount;
    }
}
