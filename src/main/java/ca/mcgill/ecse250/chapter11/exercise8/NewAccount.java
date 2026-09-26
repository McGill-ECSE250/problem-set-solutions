package ca.mcgill.ecse250.chapter11.exercise8;

import ca.mcgill.ecse250.chapter09.Account;

import java.util.ArrayList;

public class NewAccount extends Account {
    private String name;
    private final ArrayList<Transaction> transactions = new ArrayList<>();
    public NewAccount(int id, double balance, double annualInterestRate, String name) {
        super(id, balance, annualInterestRate);
        this.name = name;
    }

    public void deposit(double amount, String description) {
        super.deposit(amount);
        transactions.add(new Transaction( 'D', amount, this.getBalance(), description));
    }

    public void withdraw(double amount, String description) {
        super.withdraw(amount);
        transactions.add(new Transaction( 'W', amount, this.getBalance(), description));
    }

    @Override
    public String toString() {
        String transactionsString = "";
        for (int i = 0; i < transactions.size(); i++) {
            transactionsString += " " + transactions.get(i).toString();
        }
        return "NewAccount{" +
                "name='" + name + '\'' +
                "transactions="+ transactionsString +" }";
    }
}
