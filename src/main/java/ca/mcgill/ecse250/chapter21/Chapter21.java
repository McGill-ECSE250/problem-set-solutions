package ca.mcgill.ecse250.chapter21;

import java.util.*;

/**
 * CHAPTER 21: SETS AND MAPS
 */
public class Chapter21 {
    private static Scanner inputScanner = new Scanner(System.in);
    public static void main(String[] args) {
        exercise_21_06();
    }

    // EXERCISE 21.6: COUNT THE OCCURRENCES OF NUMBERS ENTERED
    static void exercise_21_06() {
        System.out.print("Enter a list of numbers: ");
        String numbersSeparatedBySpaceList = inputScanner.nextLine();
        String[] numbersInString = numbersSeparatedBySpaceList.split(" ");
        int[] numbers = new int[numbersInString.length];
        for (int i = 0; i < numbers.length; i++) {
            // ASSUMING THE LIST CONTAINS ONLY VALID NEGATIVE AND POSITIVE INTEGERS.
            numbers[i] = Integer.parseInt(numbersInString[i]);
        }
        System.out.println("The list of numbers that have the most occurrences in the given list of numbers is "
                + (mostOccurrencesOfNumber(numbers)));
    }


    private static Set<Integer> mostOccurrencesOfNumber(int[] numbers) {
        // Using a HashMap, we are able to save each of the numbers' occurrences
        // , meaning the number itself is unique and an occurrences may be similar, so we will form the map as (number, its occurrence)
        HashMap<Integer, Integer> occurrencesMap = buildOccurrencesMap(numbers);
        int maxOccurrences = findMaxOccurrences(numbers, occurrencesMap);
        return mapToSet(maxOccurrences, occurrencesMap, numbers);
    }

    private static Set<Integer> mapToSet(int maxOccurrences, HashMap<Integer, Integer> occurrencesMap, int[] numbers) {
        Set<Integer> keySet = new HashSet<>();
        for (int i = 0, j = 0; i < numbers.length; i++) {
            if (occurrencesMap.getOrDefault(numbers[i], 0) == maxOccurrences) {
                keySet.add(numbers[i]);
                occurrencesMap.remove(numbers[i]);
            }
        }
        var array = new Integer[keySet.size()];
        keySet.toArray(array);
        return keySet;
    }

    private static HashMap<Integer, Integer> buildOccurrencesMap(int[] numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        return map;
    }

    private static int findMaxOccurrences(int[] numbers, HashMap<Integer, Integer> map) {
        int maxOccurrences = 0;
        for (int number : numbers) {
            if (map.get(number) > maxOccurrences) {
                maxOccurrences = map.get(number);
            }
        }
        return maxOccurrences;
    }
}
