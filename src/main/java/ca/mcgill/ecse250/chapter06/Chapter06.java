package ca.mcgill.ecse250.chapter06;

import java.util.Scanner;

/**
 * CHAPTER 6: METHODS
 */
public class Chapter06 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        exercise_06_25();
        input.close();
    }

    ///////////////// EXERCISE 6.2 /////////////////
    static void exercise_06_02() {
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
        System.out.print("String s: ");
        String s = input.next();
        int result = countLetters(s);
        System.out.println("Number of letters in string " + s + " : " + result);
    }
    public static int countLetters(String s) {
        int numOfLetters = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                numOfLetters++;
            }
        }
        return numOfLetters;
    }

    // FYI: if you made your own isLetter method, a possible custom method would be the following:
    public boolean isCharacterALetter(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    // Although it is much more preferred to use library functions as much as possible
    // as they are much more tested and proven to work

    ///////////////// EXERCISE 6.22 /////////////////
    static void exercise_06_22() {
        System.out.print("long n: ");
        long n = input.nextLong();
        double result = sqrtRecursive(n);
        System.out.println("The approximate square root of " + n + " : " + result);

    }

    private static final double acceptableDelta = 0.0001;
    private static final double initialGuess = 1;
    //Algorithm using a loop:
    public static double sqrt(long n){
        double lastGuess;
        double nextGuess = initialGuess;
        do {
            lastGuess = nextGuess;
            nextGuess = (lastGuess + n / lastGuess) / 2;
        } while (!areAlmostIdentical(lastGuess, nextGuess));
        return nextGuess;
    }


    //Algorithm using recursive (Chapter 18) for the curious and the final exam practice:
    public static double sqrtRecursive(long n) {
        return sqrtRecursive(n, initialGuess);
    }
    private static double sqrtRecursive(long n, double lastGuess){
        double nextGuess = (lastGuess + n / lastGuess) / 2;
        if (areAlmostIdentical(lastGuess, nextGuess)){
            return nextGuess;
        } else {
            return sqrtRecursive(n, nextGuess);
        }
    }

    private static boolean areAlmostIdentical(double a, double b){
        return abs(a - b) < acceptableDelta;
    }

    // Equivalent to Math.abs(double n).
    private static double abs(double n){
        return (n > 0) ? n : -n;
    }

    ///////////////// EXERCISE 6.23 /////////////////
    static void exercise_06_23() {
        System.out.print("Enter the string to find the occurrences on: ");
        String occurencesString = input.next();
        System.out.print("Enter the character to find the occurrences on: ");
        char occurrencesChar = input.next().charAt(0);
        int numOfOccurrencesInString = count(occurencesString, occurrencesChar);
        System.out.println("The number of " + occurrencesChar + " in "+ occurencesString + " : " + numOfOccurrencesInString);
    }
    public static int count(String str, char a){
        int numOfOccurences = 0;
        for (char c : str.toCharArray()) {
            if (c == a) {
                numOfOccurences++;
            }
        }
        return numOfOccurences;
    }
    ///////////////// EXERCISE 6.25 /////////////////
    static void exercise_06_25() {
        System.out.print("Enter the milliseconds requested: ");
        long timeInMillisecondsRequested = input.nextLong();
        String timeCodeFormatedTime = convertMillis(timeInMillisecondsRequested);
        System.out.println("The TimeCode formated time of " + timeInMillisecondsRequested + " is: " + timeCodeFormatedTime);
    }
    private static final int MILLISECONDS_PER_SECONDS = 1000;
    private static final byte SECONDS_PER_MIN = 60;
    private static final byte MIN_PER_HOURS = 60;

    public static String convertMillis(long millis){
        long seconds = millis / MILLISECONDS_PER_SECONDS;
        long minutes = seconds / SECONDS_PER_MIN;
        seconds = seconds % SECONDS_PER_MIN;
        long hours = minutes / MIN_PER_HOURS;
        minutes = minutes % MIN_PER_HOURS;
        //Challenge: do it for DAYS:HOURS:MINUTES:SECONDS. Do you notice a computation pattern?
        return String.format("%d:%d:%d", hours, minutes, seconds);
    }

    ///////////////// EXERCISE 6.26 /////////////////
    static void exercise_06_26() {
        System.out.print("Enter number of first palindromic prime numbers you would like to see: ");
        long numRequestedOfPalindromicPrimeNumbers = input.nextLong();
        String numOfOccurrencesInString = GetPalindromicOrderedPrimesList(numRequestedOfPalindromicPrimeNumbers);
        System.out.println("The list of the first " + numRequestedOfPalindromicPrimeNumbers + ": \n" + numOfOccurrencesInString);
    }

    private static final byte NUMBERS_PER_ROW = 10;
    static private String GetPalindromicOrderedPrimesList(long requestedNum){
        int currentNumber = 2;
        byte numbersCurrentlyPrintedInRow = 0;
        long numPrinted = 0;
        StringBuilder primeList = new StringBuilder();

        for (int i = 0; numPrinted != requestedNum; /* this can be left empty! */) {
            if(isPalindrome(currentNumber)/*From EXERCISE 6.3 */ && isPrime(currentNumber)){
                if( ++numbersCurrentlyPrintedInRow != NUMBERS_PER_ROW) {
                    primeList.append(String.format("%d ", currentNumber));
                } else {
                    primeList.append(String.format("%d\n", currentNumber));
                    numbersCurrentlyPrintedInRow = 0;
                }
                numPrinted++;
            }
            currentNumber++;

        }
        return primeList.toString();
    }

    private static boolean isPrime(int n) {
        int n_sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= n_sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    ///////////////// EXERCISE 6.37 /////////////////
    static void exercise_06_37() {

        System.out.print("Enter a number: ");
        int number = input.nextInt();
        System.out.print("Enter its width: ");
        int width = input.nextInt();
        System.out.println("The number " + number + " formatted with " + width + " corresponds to " + format(number, width));
    }
    private static final String PADDING_CHARACTER = "0";
    public static String format(int number, int width){
        int numOfDigits = numOfDigits(number);
        if(numOfDigits < width){
            int numberOfZeroToBePrefixed = width - numOfDigits;
            return PADDING_CHARACTER.repeat(numberOfZeroToBePrefixed)
                    + Integer.toString(number);
        } else {
            return String.format("%d", numOfDigits);
        }
    }

    private static int numOfDigits(int number) {
        int numOfDigits = 0;
        while (number >= 1) {
            number /= 10;
            numOfDigits++;
        }
        return numOfDigits;
    }

}
