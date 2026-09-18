package ca.mcgill.ecse250.chapter10;

import ca.mcgill.ecse250.chapter09.Account;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Chapter10 {
    private static final Scanner inputScanner = new Scanner(System.in);
    public static void main(String[] args) {
        exercise_10_07();
    }

    // EXERCISE 10.7: GAME: ATM MACHINE
    private static final byte NUM_OF_ACCOUNTS = 10;
    private static final byte INITIAL_BALANCE = 100;
    private static final double INITIAL_ANNUAL_INTEREST_RATE = 0.7;
    private static final String MENU_STRING = "Main menu\n"
                                            + "1: check balance\n"
                                            + "2: withdraw\n"
                                            + "3: deposit\n"
                                            + "4: exit\n"
                                            + "Enter your choice: ";
    static void exercise_10_07() {
        Account[] accounts = new Account[NUM_OF_ACCOUNTS];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, INITIAL_BALANCE, INITIAL_ANNUAL_INTEREST_RATE);
        }
        boolean isAGoodbye = false;
        while (!isAGoodbye){
            System.out.print("Enter an id: ");
            byte id = inputScanner.nextByte();
            if (id < 0 || id >= accounts.length) {
                System.out.println("Invalid id!");
                continue;
            }
            Account chosenAccount = accounts[id];
            System.out.print(MENU_STRING);
            byte choice = inputScanner.nextByte();

            switch (choice) {
                case 1:
                    System.out.println("The balance is " + chosenAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter an amount to withdraw: ");
                    double withdrawAmount = inputScanner.nextDouble();
                    chosenAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter an amount to deposit: ");
                    double depositAmount = inputScanner.nextDouble();
                    chosenAccount.deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    isAGoodbye = true;
                    break ;
                default:
                    break;
            }
        }

    }
}
