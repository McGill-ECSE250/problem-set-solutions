package ca.mcgill.ecse250.chapter18;

import org.w3c.dom.ls.LSOutput;

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
        // BASE CASE:
        if (number <= 1) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(number).multiply(factorial(number - 1));
        }
    }

    private static final byte MAX_NUMBERS_18_3 = 2;
    static void exercise_18_03() {
        System.out.print("Enter 2 numbers separated by space: ");
        String numbersSeparatedBySpaceList = inputScanner.nextLine();
        String[] numbersInString = numbersSeparatedBySpaceList.split(" ");
        int[] numbers = new int[MAX_NUMBERS_18_3];
        for (int i = 0; i < MAX_NUMBERS_18_3; i++) {
            numbers[i] = Integer.parseInt(numbersInString[i]);
        }
        System.out.println("GCD of the following numbers is " + gcd(numbers[0], numbers[1]));

    }

    // compare with Chapter 7's for loop method: which one is more elegant? which one is more performant?
    private static int gcd(int a, int b) {
        return b % a == 0 ? a : gcd(b, a % b);
    }

    private static final byte I_UP_TO_18_5 = 10;
    static void exercise_18_05() {
        System.out.println("s m(i) for i = 1, 2, . . ., 10:");
        for (int i = 0; i <= I_UP_TO_18_5; i++) {
            System.out.println("m(" + i + ") = " + sumSeries18_5(i));
        }
    }

    static double sumSeries18_5(int i){
        // BASE CASE:
        if(i <= 0){
            return 0;
        } else {
            return  sumSeries18_5(i - 1) + (double) (i) / (2 * i + 1);
        }
    }

    static void exercise_18_07() {
        ComputeFibonacci.main(new String[0]);
    }

    static void exercise_18_09() {
        System.out.println("Enter string to reverse:");
        String stringToReverse = inputScanner.nextLine();
        reverseDisplay(stringToReverse);
    }
    public static void reverseDisplay(String value){
        // BASE CASE:
        if(value.length() <= 1){
            System.out.print(value);
            return;
        }
        System.out.print(value.charAt(value.length() - 1));
        reverseDisplay(value.substring(0, value.length() - 1));
    }
    static void exercise_18_18() {
        TowerOfHanoi.main(new String[0]);
    }

    static void exercise_18_21() {
        System.out.print("Enter an decimal integer to convert to binary: ");
        int number = inputScanner.nextInt();
        System.out.println("The binary representation of " + number + " is " + dec2Bin(number));
    }
    public static String dec2Bin(int value){
        // BASE CASE
        if (value == 1 || value == 0) {
            return String.valueOf(value);
        }
        return  dec2Bin(value / 2)  + dec2Bin(value % 2); // if you think about it dec2Bin(value % 2) == if (value == 1 || value == 0) { return String.valueOf(value);
    }
    public static String dec2BinAlternative(int value){
        // BASE CASE
        if (value == 1 || value == 0) {
            return String.valueOf(value);
        }
        return  dec2Bin(value / 2) + ( value % 2 == 0 ? "0" : "1" );
    }
}
