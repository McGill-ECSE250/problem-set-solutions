package ca.mcgill.ecse250.chapter07;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

/**
 * CHAPTER 7: SINGLE-DIMENSIONAL ARRAYS
 */
public class Chapter07 {
    private final static Scanner inputScanner = new Scanner(System.in);
    public static void main(String[] args) {
        exercise_07_12();
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

    // EXERCISE 7.4 ANALYZE SCORES
    static void exercise_07_04() {
        //Assume that the maximum number of scores is 100 < 127 (max byte)
        System.out.print("Unspecified number of scores: ");
        String numbersSeparatedBySpaceList = inputScanner.nextLine();
        String[] numbersInString = numbersSeparatedBySpaceList.split(" ");

        long[] numbers = new long[getListSizeBeforeNegativeNumber(numbersInString)];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Long.parseLong(numbersInString[i]);
        }

        byte belowAverage = countBelowAverage(numbers);
        // all numbers (numbers.length) are formed by -> below average ones (belowAverage) + above average + equal to average
        // so, average + equal = all numbers - below average ones
        byte aboveAndEqualAverage = (byte) (numbers.length - belowAverage);

        long average = computeAverage(numbers);

        System.out.println( belowAverage + " are below the average of " + average
                + "\n" + (numbers.length - belowAverage) + " are above or equal to the average of " + average);



    }



    private static byte getListSizeBeforeNegativeNumber(String[] numbersInString) {
        byte sizeOfListOfScores = 0;
        while (Integer.parseInt(numbersInString[sizeOfListOfScores]) >= 0) {
            sizeOfListOfScores++;
        }
        return sizeOfListOfScores;
    }


    private static byte countBelowAverage(long[] numbers) {
        long average = computeAverage(numbers);
        byte count = 0;
        for (long number : numbers) {
            if (number < average) {
                count++;
            }
        }
        return count;
    }

    private static long computeAverage(long[] numbers) {
        return sum(numbers) / numbers.length;
    }

    private static long sum(long[] numbers) {
        long sum = 0;
        for (long number : numbers) {
            sum += number;
        }
        return sum;
    }


    // EXERCISE 7.5 PRINT DISTINCT NUMBERS
    private static final byte MAX_NUMBERS = 10;
    static void exercise_07_05() {
        System.out.print("Enter ten numbers: ");
        String numbersSeparatedBySpaceList = inputScanner.nextLine();
        String[] numbersInString = numbersSeparatedBySpaceList.split(" ");
        int[] numbers = new int[MAX_NUMBERS];
        for (int i = 0; i < MAX_NUMBERS; i++) {
            numbers[i] = Integer.parseInt(numbersInString[i]);
        }
        // 10 numbers < 127 (max byte value)
        byte distinctNumbersCount = 0;
        int[] distinctNumbersArray = new int[MAX_NUMBERS];
        for (int n : numbers) {
            if (!contains(n, distinctNumbersArray)){
                distinctNumbersArray[distinctNumbersCount++] = n;
            }
        }
        System.out.println("The number of distinct numbers is: " + distinctNumbersCount +
                "\nThe distinct numbers are: " + formatArrayToString(distinctNumbersArray, distinctNumbersCount));
    }

    private static String formatArrayToString(int[] distinctNumbersArray, int size) {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += distinctNumbersArray[i] + " "; // can also use StringBuilder
        }
        return s.trim(); // to remove the last space put
    }

    private static boolean contains(int n, int[] numbers) {
        boolean foundOne = false;
        for (int number : numbers) {
            if (number == n) {
                return true;
            }
        }
        return false;
    }

    // EXERCISE 7.9 FIND THE SMALLEST ELEMENT
    static void exercise_07_09() {
        System.out.print("Enter ten numbers: ");
        String numbersSeparatedBySpaceList = inputScanner.nextLine();
        String[] numbersInString = numbersSeparatedBySpaceList.split(" ");
        double[] numbers = new double[MAX_NUMBERS];
        for (int i = 0; i < MAX_NUMBERS; i++) {
            numbers[i] = Double.parseDouble(numbersInString[i]);
        }
        System.out.println("Min number of the list is " + min(numbers));


    }
    public static double min(double[] array){
        double min = Double.MAX_VALUE;
        for (double n : array){
            if(n < min){
                min = n;
            }
        }
        return min;
    }

    // EXERCISE 7.10 FIND THE INDEX OF THE SMALLEST ELEMENT
    static void exercise_07_10() {
        System.out.print("Enter ten numbers: ");
        String numbersSeparatedBySpaceList = inputScanner.nextLine();
        String[] numbersInString = numbersSeparatedBySpaceList.split(" ");
        double[] numbers = new double[MAX_NUMBERS];
        for (int i = 0; i < MAX_NUMBERS; i++) {
            numbers[i] = Double.parseDouble(numbersInString[i]);
        }

        System.out.println("The index of the min number of the list is " + indexOfSmallestElement(numbers));
        // Do not forget to start counting from 0 on arrays!
    }

    public static int indexOfSmallestElement(double[] array){
        double min = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if(array[i] < min){
                min = array[i];
                index = i;
            }
        }
        return index;
    }


    // EXERCISE 7.12 REVERSE AN ARRAY
    static void exercise_07_12() {
        System.out.print("Enter ten numbers: ");
        String numbersSeparatedBySpaceList = inputScanner.nextLine();
        String[] numbersInString = numbersSeparatedBySpaceList.split(" ");
        int[] numbers = new int[MAX_NUMBERS];
        for (int i = 0; i < MAX_NUMBERS; i++) {
            numbers[i] = Integer.parseInt(numbersInString[i]);
        }
        reverseArray(numbers);
        System.out.println("The index of the min number of the list is " + formatArrayToString(numbers, numbers.length));
    }
    public static int[] reverseArray(int[] list) {
        for (int i = 0, j = list.length - 1; i < list.length / 2; i++, j--) {
             int tmp = list[j];
             list[j] = list[i];
             list[i] = tmp;
        }
        return list;
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