package ca.mcgill.ecse250.chapter09;

import java.util.Date;
import java.util.Scanner;

public class Chapter09 {
    private static final Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        exercise_09_10();
    }

    static void exercise_09_07() {
        Account account = new Account(1122, 20000, 4.5/100.0);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("Account's Balance: " + account.getBalance());
        System.out.println("Account's Monthly Interest Rate: " + account.getMonthlyInterestRate());
        System.out.println("Account's Creation Date: " + account.getDateCreated());

    }






    static void exercise_09_08() {
        Fan fanA = new Fan();
        fanA.setSpeed(Fan.FAST);
        fanA.setRadius(10.0);
        fanA.setColor("yellow");
        fanA.setOn(true);
        Fan firstObject = fanA; // turn it into the first object (this is redundant but following the instructions)
        Fan fanB = new Fan();
        fanB.setSpeed(Fan.MEDIUM);
        fanB.setRadius(5.0);
        fanB.setColor("blue");
        fanB.setOn(false);
        Fan secondObject = fanB; //turn it into the second object (this is redundant but following the instructions)
        System.out.println("First Object: " + firstObject
                       + "\nSecond Object: " + secondObject);
    }

    static void exercise_09_10() {
        QuadraticEquation eq = QuadraticEquation.requestEquation();
        System.out.println("First Root: " + eq.getRoot1());
        System.out.println("Second Root: " + eq.getRoot2());
    }

}


