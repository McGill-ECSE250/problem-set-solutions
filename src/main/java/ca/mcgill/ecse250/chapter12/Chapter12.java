package ca.mcgill.ecse250.chapter12;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Chapter12 {

    private static final Scanner inputScanner = new Scanner(System.in);
    public static void main(String[] args) {
        exercise_12_07();
    }

    static void exercise_12_02() {
        double a = 1.0;
        double b = -1.0;
        do {
            System.out.printf("%f + %f = ", a, b);
        } while (!evaluateAnswer(a + b));
    }

    private static boolean evaluateAnswer(double expectedResult) {
        try{
            double answer = inputScanner.nextDouble();
            if (answer == expectedResult) {
                System.out.println("You guessed the correct result!");
            } else {
                System.out.println("Incorrect result given!");
            }
            return answer == expectedResult;

        } catch (InputMismatchException e){
            System.out.println("Wrong input type given!");
            inputScanner.nextLine(); // clean up the terminal for next call
        } catch (Exception e){
            System.out.println("Unknown error caught!");
            inputScanner.nextLine(); // clean up the terminal for next call
        }
        return false;
    }

    private static final byte NUM_OF_CHOSEN_INTEGERS = 100;
    static void exercise_12_03() {
        int[] numbers = new int[NUM_OF_CHOSEN_INTEGERS];
        createArray(numbers);
        System.out.print("An array of 100 elements has been generated. Enter the index you would like to view the value of: ");
        evaluateInteger(numbers);
    }

    private static void evaluateInteger(int[] numbers) {
        try{
            byte index = inputScanner.nextByte();
            int value = numbers[index];
            System.out.println("the number at index " + index + " is " + value);
        } catch (InputMismatchException e){
            System.out.println("Wrong input type given!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of Bounds");

        }catch (Exception e){
            System.out.println("Unknown error caught!");
        }
    }

    private static final int LOWER_RANDOM_BOUND = 0;
    private static final int UPPER_RANDOM_BOUND = 150;
    private static void createArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Random().nextInt(LOWER_RANDOM_BOUND, UPPER_RANDOM_BOUND);
        }
    }

    static void exercise_12_07() {
        System.out.println("Input a binary number");
        try {
            String binaryNumberInString = inputScanner.nextLine();
            double result = bin2Dec(binaryNumberInString);
            System.out.printf("The decimal value of %s is %f%n", binaryNumberInString, result);
        } catch (NumberFormatException e) {
            System.out.println("The number entered is not a valid binary number");
        } catch (InputMismatchException e) {
            System.out.println("invalid input!");
        }
    }
    private static double bin2Dec(String binaryString) throws NumberFormatException { // when implementing exceptions that are meant to be thrown and not internally handled a good practice is to annotate it like we do here for users of the functions
        double result = 0.0;
        int decimalPointIndex = binaryString.indexOf(".");
        final boolean hasDecimalPoint = decimalPointIndex != -1;
        boolean foundDecimalPoint = false; // make sure only one point is there
        int binaryStringLength = binaryString.length();

        for (int i = 0; i < binaryStringLength; i++){
            char ch = binaryString.charAt(i);
            switch(ch){
                case '.':
                    if (foundDecimalPoint){
                        throw new NumberFormatException();
                    }
                    foundDecimalPoint = true;
                    break;
                case '0':
                    break;
                case '1':
                    if (!hasDecimalPoint){
                        result += Math.pow(2, ((binaryStringLength - 1) - i));
                    } else {
                        result += (foundDecimalPoint) ? Math.pow(2, (decimalPointIndex) - i) : Math.pow(2, (decimalPointIndex - 1) - i);
                    }

                    break;
                default:
                    throw new NumberFormatException();
            }
        }
        return result;
    }
}
