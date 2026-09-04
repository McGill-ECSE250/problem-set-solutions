package ca.mcgill.ecse250.chapter04;

import java.util.Scanner;

/**
 * CHAPTER 4: MATHEMATICAL FUNCTIONS, CHARACTERS, AND STRINGS
 */
public class Chapte04 {

    public static void main(String[] args) {
        exercise_04_25();
    }

    static void exercise_04_08() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an ASCII code: ");
        int c = input.nextInt();
        System.out.println("The character for ASCII code " + c + " is " + ((char) c));
    }

    static void exercise_04_12() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a hex digit: ");
        String digit = input.nextLine();
        char digitChar = digit.charAt(0);
        int number;
        if (digitChar >= '0' && digitChar <= '9') {
            number = Integer.parseInt(digit);
        } else if (digitChar >= 'A' && digitChar <= 'F') {
            number = digitChar - 'A' + 10;
        } else if (digitChar >= 'a' && digitChar <= 'f') {
            number = digitChar - 'a' + 10;
        } else {
            System.out.println("Invalid input.");
            return;
        }

        int power3 = number / 8;
        number = number % 8;
        int power2 = number / 4;
        number = number % 4;
        int power1 = number / 2;
        number = number % 2;

        System.out.println("The binary value is " + power3 + power2 + power1 + number);
    }

    static void exercise_04_13() {
        String vowels = "aeiouyAEIOUY";

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        String letter = input.nextLine();

        if (vowels.contains(letter)) {
            System.out.println(letter + " is a vowel");
        } else {
            System.out.println(letter + " is a consonant");
        }
    }

    static void exercise_04_20() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String in = input.nextLine();

        System.out.println("The length of the string is " + in.length());
        System.out.println("The first character in the string is " + in.charAt(0));
    }

    static void exercise_04_22() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter string s1: ");
        String line1 = input.nextLine();
        System.out.print("Enter string s2: ");
        String line2 = input.nextLine();

        if (line1.contains(line2)) {
            System.out.println(line2 + " is a substring of " + line1);
        } else {
            System.out.println(line2 + " is not a substring of " + line1);
        }
    }

    static void exercise_04_23() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter employee's name: ");
        String name = input.nextLine();
        System.out.print("Enter number of hours worked in a week: ");
        double hoursWorked = input.nextDouble();
        System.out.print("Enter hourly pay rate: ");
        double payRate = input.nextDouble();
        System.out.print("Enter federal tax withholding rate: ");
        double federalTaxRate = input.nextDouble();
        System.out.print("Enter provincial tax withholding rate: ");
        double provincialTaxRate = input.nextDouble();

        double grossPay = hoursWorked*payRate;
        double federalDeduction = grossPay*federalTaxRate;
        double provincialDeduction = grossPay*provincialTaxRate;
        double totalDeduction = federalDeduction + provincialDeduction;
        double netPay = grossPay - totalDeduction;

        System.out.printf("Employee Name: " + name + "\n");
        System.out.printf("Hours Worked: " + hoursWorked + "\n");
        System.out.printf("Pay Rate: $%.2f\n",payRate);
        System.out.printf("Gross Pay: $%.2f\n",grossPay);
        System.out.print("Deductions:\n");
        System.out.printf("\tFederal Withholding (%.1f%%): $%.2f\n",federalTaxRate*100,federalDeduction);
        System.out.printf("\tProvincial Withholding (%.1f%%): $%.2f\n",provincialTaxRate*100,provincialDeduction);
        System.out.printf("\tTotal Deduction: $%.2f\n",totalDeduction);
        System.out.printf("Net Pay: $%.2f\n",netPay);
    }

    static void exercise_04_24() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first city: ");
        String city1 = input.nextLine();
        System.out.print("Enter the second city: ");
        String city2 = input.nextLine();
        System.out.print("Enter the third city: ");
        String city3 = input.nextLine();

        String first;
        String second;
        String third;

        if (city1.compareTo(city2) <= 0 && city1.compareTo(city3) <= 0) {
            first = city1;
            if (city2.compareTo(city3) <= 0) {
                second = city2;
                third = city3;
            } else {
                second = city3;
                third = city2;
            }

        } else if (city2.compareTo(city1) <= 0 && city2.compareTo(city3) <= 0) {
            first = city2;
            if (city1.compareTo(city3) <= 0) {
                second = city1;
                third = city3;
            } else {
                second = city3;
                third = city1;
            }
        } else {
            first = city3;
            if (city1.compareTo(city2) <= 0) {
                second = city1;
                third = city2;
            } else {
                second = city2;
                third = city1;
            }
        }
        System.out.println("The three cities in alphabetical order are: " + first + ", " + second + ", " + third);
    }

    static void exercise_04_25() {
        char letter1 = (char) ((int)(Math.random() * 26) + 'A');
        char letter2 = (char) ((int)(Math.random() * 26) + 'A');
        char letter3 = (char) ((int)(Math.random() * 26) + 'A');
        int number1 = (int)(Math.random() * 10);
        int number2 = (int)(Math.random() * 10);
        int number3 = (int)(Math.random() * 10);
        int number4 = (int)(Math.random() * 10);
        System.out.println("A random vehicle plate number: " + letter1 + letter2 + letter3 + number1 + number2 + number3 + number4);
    }
}
