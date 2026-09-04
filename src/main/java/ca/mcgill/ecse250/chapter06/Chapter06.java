package ca.mcgill.ecse250.chapter06;

import java.util.Scanner;

/**
 * CHAPTER 6: METHODS
 */
public class Chapter06 {

    public static void main(String[] args) {
        exercise_06_08();
    }

    ///////////////// EXERCISE 6.2 /////////////////
    static void exercise_06_02() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        int sum = sumDigits(n);
        System.out.println("The sum of digits for " + n + " is " + sum);
    }

    public static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + (n % 10);
            n = n / 10;
        }
        return sum;
    }

    ///////////////// EXERCISE 6.3 /////////////////
    static void exercise_06_03() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        boolean isPal = isPalindrome(n);

        if (isPal) {
            System.out.println(n + " is a palindrome");
        } else {
            System.out.println(n + " is not a palindrome");
        }
    }

    public static int reverse(int number) {
        int reversed = 0;
        while (number > 0) {
            reversed = reversed * 10 + (number % 10);
            number = number / 10;
        }
        return reversed;
    }

    public static boolean isPalindrome(int number) {
        int reverseNumber = reverse(number);
        return number == reverseNumber;
    }

    ///////////////// EXERCISE 6.8 /////////////////
    static void exercise_06_08() {
        System.out.println("Celsius      Fahrenheit       |      Fahrenheit      Celsius");
        System.out.println("--------------------------------------------------------------");

        double startCelsius = -5;
        double startFahrenheit = 25;
        double gapCelsius = 5;
        double gapFahrenheit = 10;
        for (int i = 0; i < 10; i++) {
            double celsius = startCelsius + gapCelsius*i;
            double fahrenheit = startFahrenheit + gapFahrenheit*i;

            System.out.printf("%-15.1f%-15.1f|       %-15.1f%-15.2f%n",celsius, celsiusToFahrenheit(celsius), fahrenheit, fahrenheitToCelsius(fahrenheit));
        }
        System.out.println();
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5) * celsius + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9) * (fahrenheit - 32);
    }

    ///////////////// EXERCISE 6.20 /////////////////
    static void exercise_06_20() {

    }

    ///////////////// EXERCISE 6.22 /////////////////
    static void exercise_06_22() {

    }

    ///////////////// EXERCISE 6.23 /////////////////
    static void exercise_06_23() {

    }

    ///////////////// EXERCISE 6.25 /////////////////
    static void exercise_06_25() {

    }

    ///////////////// EXERCISE 6.26 /////////////////
    static void exercise_06_26() {

    }

    ///////////////// EXERCISE 6.37 /////////////////
    static void exercise_06_37() {

    }

}
