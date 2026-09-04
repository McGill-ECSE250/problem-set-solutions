package ca.mcgill.ecse250.chapter03;

import java.util.Scanner;

/**
 * CHAPTER 3: SELECTIONS
 */
public class Chapter03 {

    public static void main(String[] args) {
        exercise_03_04();
    }

    static void exercise_03_01() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double discriminant = b*b - 4*a*c;

        if (discriminant < 0) {
            System.out.println("This equation has no real roots.");
        } else if (discriminant == 0) {
            double root = -1*b/(2*a);
            System.out.println("This equation has one root: " + root);
        } else {
            double root1 = (-1*b + Math.pow(discriminant,0.5))/(2*a);
            double root2 = (-1*b - Math.pow(discriminant,0.5))/(2*a);
            System.out.println("This equation has two roots: " + root1 + " and " + root2);
        }

    }

    static void exercise_03_04() {
        int monthNumber = (int)(Math.random() * 12 + 1);
        String month;

        switch (monthNumber) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            default:
                month = "December";
                break;
        }
        System.out.println("The month is " + month);
    }

    static void exercise_03_05() {
        String[] daysOfWeek = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

        Scanner input = new Scanner(System.in);
        System.out.print("Enter today's day of week (0 to 6): ");
        int today = input.nextInt();
        System.out.print("Enter the number of days elapsed since today: ");
        int daysElapsed = input.nextInt();

        int futureDay = (today + daysElapsed) % 7;

        String todayString = daysOfWeek[today];
        String futureDayString = daysOfWeek[futureDay];

        System.out.println("Today is " + todayString + " and the future day is " + futureDayString);
    }

    static void exercise_03_26() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        boolean divByFive = ((number % 5) == 0);
        boolean divBySix = ((number % 6) == 0);

        System.out.println("Is " + number + " divisible by 5 and 6? " + (divByFive && divBySix));
        System.out.println("Is " + number + " divisible by 5 or 6? " + (divByFive || divBySix));
        System.out.println("Is " + number + " divisible by 5 or 6, but not both? " + (divByFive ^ divBySix));
    }

    static void exercise_03_28() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter r1 center x-, y-coordinates, width, and height: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double w1 = Math.abs(input.nextDouble());
        double h1 = Math.abs(input.nextDouble());

        System.out.print("Enter r2 center x-, y-coordinates, width, and height: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double w2 = Math.abs(input.nextDouble());
        double h2 = Math.abs(input.nextDouble());

        boolean r2InsideR1 = ((Math.abs(x2-x1) + (w2/2)) <= w1/2) && ((Math.abs(y2-y1) + (h2/2)) <= h1/2);
        boolean r2NoOverlapsR1 = (Math.abs(x2-x1) >= ((w2/2) + (w1/2))) || (Math.abs(y2-y1) >= ((h2/2) + (h1/2)));

        if (r2InsideR1) {
            System.out.println("r2 is inside r1");
        } else if (r2NoOverlapsR1) {
            System.out.println("r2 does not overlap r1");
        } else {
            System.out.println("r2 overlaps r1");
        }

    }
}
