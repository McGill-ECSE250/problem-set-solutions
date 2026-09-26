package ca.mcgill.ecse250.chapter11.exercise8;

import java.util.Date;

public class Transaction {
    // The date of this transaction
    private Date date;
    // The type of the transaction, such as 'W' for withdrawal, 'D'for deposit
    private char type;
    // The amount of the transaction.
    private double amount;
    // The new balance after this transaction.
    private double balance;
    // The description of this transaction.
    private String description;

    /* Constructs a Transaction with the specified
     date, type,balance, and description*/
    public Transaction(char type, double amount, double balance, String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", type=" + type +
                ", amount=" + amount +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                '}';
    }
}
