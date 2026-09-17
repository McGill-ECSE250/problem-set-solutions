package ca.mcgill.ecse250.chapter09;

import java.util.Date;
import java.util.Scanner;

public class Chapter09 {
    private static final Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
    }

    static void exercise_09_07() {
        class Account {
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

    }






    static void exercise_09_08() {
        class Fan {
            private static final byte SLOW = 1;
            private static final byte MEDIUM = 2;
            private static final byte FAST = 3;
            private int speed = SLOW;
            private boolean on = false;
            private double radius = 5.0;
            private String color = "blue";

            @Override
            public String toString() {
                return on ? "Description of fan:" +
                        "speed=" + speed +
                        ", radius=" + radius +
                        ", color='" + color + '\'' +
                        '}'
                        : "fan is off";
            }

            public void setSpeed(int speed) {
                this.speed = speed;
            }

            public void setOn(boolean on) {
                this.on = on;
            }

            public void setRadius(double radius) {
                this.radius = radius;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public int getSpeed() {
                return speed;
            }

            public String getColor() {
                return color;
            }

            public double getRadius() {
                return radius;
            }

            public boolean isOn() {
                return on;
            }
        }
    }

    static void exercise_09_10() {
        class QuadraticEquation {
            private double a;
            private double b;
            private double c;
            QuadraticEquation(double a, double b, double c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }
            double getDiscriminant(){
                return b * b - 4 * a * c;
            }
            double getRoot1(){
                if(getDiscriminant() < 0){
                    return 0;
                }
                 return ( - b + Math.pow(getDiscriminant(), 0.5) ) / (2 * a);
            }
            //Additional challenge: can you find a way to reuse some of the code
            // by creating a helper used in Root1() and Root2()
            double getRoot2(){
                if(getDiscriminant() < 0){
                    return 0;
                }
                return ( - b - Math.pow(getDiscriminant(), 0.5) ) / (2 * a);
            }
        }
    }

}


