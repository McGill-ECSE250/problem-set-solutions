package ca.mcgill.ecse250.chapter05;

import java.util.Scanner;

/**
 * CHAPTER 5: LOOPS
 */
public class Chapter05 {
    public static void main(String[] args) {
        exercise_05_46();
    }

    static void exercise_05_01() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter integers ending with 0: ");
        double sum = 0;
        int pos_count = 0;
        int neg_count = 0;
        int num = input.nextInt();

        while (num != 0) {
            sum = sum + num;
            if (num < 0) {
                neg_count += 1;
            } else {
                pos_count += 1;
            }
            num = input.nextInt();
        }

        System.out.println("The number of positives is " + pos_count);
        System.out.println("The number of negatives is " + neg_count);
        System.out.println("The total is " + sum);
        System.out.println("The average is " + (sum/(pos_count+neg_count)));
    }

    static void exercise_05_07() {
        double tuition = 10000;
        double yearlyIncrease = 1.05;
        double totalAfter10 = 0;
        for (int i = 1; i < 15; i++) {
            tuition = tuition * yearlyIncrease;

            if (i > 10) {
                totalAfter10 = totalAfter10 + tuition;
            }
        }

        System.out.printf("The total cost of four years worth of tuition between years 11 and 14 is: $%.2f\n", totalAfter10);
    }

    static void exercise_05_12() {
        int n = 1;
        while (n*n <= 12000){
            n = n + 1;
        }
        System.out.println("The smallest integer n such that n*n > 12,000 is " + n);
    }

    static void exercise_05_23() {
        // left to right
        double total = 0;
        for (int i = 1; i <= 50000; i++) {
            total = total + 1.0/i;
        }
        System.out.println("Left to right: " + total);

        // right to left
        for (int i = 50000; i >= 1; i--) {
            total = total + 1.0/i;
        }
        System.out.println("Right to left: " + total);

    }

    static void exercise_05_26() {
        double e = 1;
        double item = 1;
        e = e + item;
        System.out.printf("i = 1: %.16f\n",e);
        for (int i = 2; i <= 20; i++) {
            item = item/i;
            e = e + item;
            System.out.printf("i = %d: %.16f\n",i,e);
        }
    }

    static void exercise_05_37() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int decimal = input.nextInt();

        if (decimal == 0) {
            System.out.println("0's binary representation is 0");
        } else {
            String binary = "";
            int remainder = decimal;
            while (remainder > 0) {
                binary = (remainder % 2) + binary;
                remainder = remainder / 2;
            }
            System.out.println(decimal + "'s binary representation is " + binary);
        }
    }

    static void exercise_05_46() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String in = input.nextLine();

        System.out.print("The reversed string is ");

        for (int i = in.length()-1; i >= 0; i--) {
            System.out.print(in.charAt(i));
        }
    }

    static void exercise_05_50() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String in = input.nextLine();

        int upperCaseCount = 0;
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                upperCaseCount++;
            }
        }

        System.out.println("The number of uppercase letters is " + upperCaseCount);

    }
}
