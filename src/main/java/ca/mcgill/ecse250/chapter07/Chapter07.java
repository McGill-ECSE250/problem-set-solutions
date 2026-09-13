package ca.mcgill.ecse250.chapter07;

import java.util.Scanner;

/**
 * CHAPTER 7: SINGLE-DIMENSIONAL ARRAYS
 */
public class Chapter07 {
    private final static Scanner inputScanner = new Scanner(System.in);
    public static void main(String[] args) {
        exercise_07_03();
        inputScanner.close();
    }



    // EXERCISE 7.2 REVERSE THE NUMBERS ENTERED

    private static final int NUMBER_OF_INTEGERS = 10;
    static void exercise_07_02() {
        System.out.println("Solution #1");
        exercise_07_02_sol1();
        System.out.println("\nSolution #2");
        exercise_07_02_sol2();
    }

    // placing directly the numbers in the reversed order, then reading in default order.
    private static void exercise_07_02_sol1(){
        int[] numbers = new int[NUMBER_OF_INTEGERS];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number #" + (i + 1) + " : ");
            numbers[(numbers.length - 1) - i] = inputScanner.nextInt();
        }
        System.out.println("Reversed List:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    // placing the number in the original order, then reading in reverse order.
    private static void exercise_07_02_sol2() {
        int[] numbers = new int[NUMBER_OF_INTEGERS];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number #" + (i + 1) + " : ");
            numbers[i] = inputScanner.nextInt();
        }
        System.out.println("Reversed List:");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
    }

    // EXERCISE 7.3 COUNT OCCURRENCES OF NUMBERS BETWEEN 1 AND 100
    private static final byte STARTING_VALUE = 1;
    private static final byte ENDING_VALUE = 100;
    static void exercise_07_03() {
        System.out.print("Enter the integers between 1 and 100: ");
        String numbersSeparatedBySpaceList = inputScanner.nextLine();
        String[] numbersInString = numbersSeparatedBySpaceList.split(" ");
        //using byte since we can assume it is between 1 and 100
        byte[] numbers = new byte[numbersInString.length];

        for (int i = 0; i < numbersInString.length; i++) {
            numbers[i] = Byte.parseByte(numbersInString[i]);
            // if int[] numbers, you would use numbers[i] = Integer.parseInt(numbersInString[i])
        }
        for (byte i = STARTING_VALUE; i <= ENDING_VALUE; i++) {
            int numberOccurrences = numberOfOccurrences(numbers, i);
            if (numberOccurrences > 0) {
                System.out.println(i + " occurs " + numberOccurrences + ((numberOccurrences > 1) ? " times" : " time"));
            }
        }
    }
    private static int numberOfOccurrences(byte[] numbers, byte i) {
        int count = 0;
        for (byte number : numbers) {
            if (number == i) {
                count++;
            }
        }
        return count;
    }

    //Challenge for the final can you do it in a

    static void exercise_07_04() {

    }

    static void exercise_07_05() {

    }

    static void exercise_07_09() {

    }

    static void exercise_07_10() {

    }

    static void exercise_07_12() {

    }

    static void exercise_07_14() {

    }

    static void exercise_07_19() {

    }

    static void exercise_07_23() {

    }

    static void exercise_07_30() {

    }

    static void exercise_07_31() {

    }
}