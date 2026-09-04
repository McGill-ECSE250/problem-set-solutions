package ca.mcgill.ecse250.chapter02;

import java.util.Scanner;

/**
 * CHAPTER 2: ELEMENTARY PROGRAMMING
 */
public class Chapter02 {

    public static void main(String[] args) {
        exercise_02_01();
    }

    static void exercise_02_01() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a temperature in Celsius: ");

        double celsius = input.nextDouble();
        double fahrenheit = (9.0/5) * celsius + 32;

        System.out.println( celsius + " Celsius is " + fahrenheit + " Fahrenheit");
    }

    static void exercise_02_02() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius and length of a cylinder: ");

        double radius = input.nextDouble();
        double length = input.nextDouble();
        double area = radius * radius * Math.PI;
        double volume = area * length;

        System.out.println("The area is " + area);
        System.out.println("The volume of the cylinder is " + volume);
    }

    static void exercise_02_03() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a value for feet: ");

        double feet = input.nextDouble();
        double meters = 0.305 * feet;

        System.out.println( feet + " feet is " + meters + " meters");
    }

    static void exercise_02_05() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter subtotal and gratuity rate: ");

        double subtotal = input.nextDouble();
        double gratuityRate = input.nextDouble();

        double gratuityAmount = (gratuityRate / 100) * subtotal;
        double totalAmount = subtotal + gratuityAmount;

        System.out.println("The gratuity is " + gratuityAmount + ", and the total is " + totalAmount);
    }

    static void exercise_02_06() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer between 0 and 1000: ");
        int number = input.nextInt();

        if (number < 0 || number > 1000) {
            System.out.println("Invalid integer.");
            return;
        }

        int firstDigit = number / 100;
        int remainder = number % 100;
        int secondDigit = remainder / 10;
        remainder = remainder % 10;
        int thirdDigit = remainder;

        int sum = firstDigit + secondDigit + thirdDigit;
        System.out.println("The sum of all digits in " + number + " is " + sum);
    }

    static void exercise_02_07() {
        Scanner input = new Scanner(System.in);

        int minutesInYear = 60*24*365;
        int minutesInDay = 60*24;
        System.out.print("Enter the number of minutes: ");
        int minutes = input.nextInt();

        int years = minutes / minutesInYear;
        int days = (minutes % minutesInYear) / minutesInDay;

        System.out.println(minutes + " minutes is approximately " + years + " years and " + days + " days");
    }

    static void exercise_02_11() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of years: ");
        int years = input.nextInt();

        int currentPopulation = 312032486;
        double secondsInAYear = 3600*24*365.0;
        double diff = secondsInAYear/7 - secondsInAYear/13 + secondsInAYear/45;

        int finalPopulation = (int) (currentPopulation + diff*years);
        System.out.println("The population in " + years + " years is " + finalPopulation);
    }

    static void exercise_02_12() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter speed v: ");
        double v = input.nextDouble();

        System.out.print("Enter acceleration a: ");
        double a = input.nextDouble();

        double runwayLength = (v*v)/(2*a);

        System.out.println("The minimum runway length for this airplane is " + runwayLength + " meters");
    }

    static void exercise_02_15() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter x1 and y1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        System.out.print("Enter x2 and y2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        double distance = Math.pow(Math.pow(x2-x1,2)+Math.pow(y2-y1,2),0.5);

        System.out.println("The distance of the two points is " + distance);
    }

}
