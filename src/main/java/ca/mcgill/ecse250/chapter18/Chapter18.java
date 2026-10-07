package ca.mcgill.ecse250.chapter18;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * CHAPTER 18: RECURSION
 */
public class Chapter18 {

    private static final Scanner inputScanner = new Scanner(System.in);
    public static void main(String[] args) {
    }

    static void exercise_18_01() {
        System.out.println("Input an integer: ");
        int number = inputScanner.nextInt();
        System.out.printf("!%d = %s", number, factorial(number));
    }

    private static BigInteger factorial(int number) {
        if (number <= 1) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(number).multiply(factorial(number - 1));
        }
    }


    static void exercise_18_03() {

    }
    //compare with Chapter 7's for loop method: which one is more elegant? which one is more performant?
    private static int gcdBetweenRec(int a, int b) {
        return b == 0 ? a : gcdBetweenRec(b, a % b);
    }

    static void exercise_18_05() {

    }

    static void exercise_18_07() {

    }

    static void exercise_18_09() {

    }

    static void exercise_18_18() {

    }

    static void exercise_18_21() {

    }
}
