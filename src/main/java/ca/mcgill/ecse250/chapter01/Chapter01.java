package ca.mcgill.ecse250.chapter01;

/**
 * CHAPTER 1: INTRODUCTION TO COMPUTERS, PROGRAMS, AND JAVA
 */
public class Chapter01 {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 10; j++) {
            i++;
            System.out.println(j);
        }
    }

    static void exercise_01_02() {
        for(int i = 0; i <   5; i++) {
            System.out.println("Welcome to Java");
        }
    }

    static void exercise_01_04() {
        System.out.println("a     a^2     a^3");
        for(int i = 1; i < 5; i++) {
            int a2 = (int) Math.pow(i,2);
            int a3 = (int) Math.pow(i,3);
            System.out.println(i+"     "+a2+"     "+a3);
        }
    }

    static void exercise_01_11() {
        int currentPopulation = 312032486;
        double secondsInAYear = 3600*24*365.0;
        int diff = (int) (secondsInAYear/7 - secondsInAYear/13 + secondsInAYear/45);
        System.out.println("Initial population: " + currentPopulation);
        for(int i = 1; i <= 5; i++) {
            int newPopulation = currentPopulation + diff;
            System.out.println("Year " + i + ": " + newPopulation);
            currentPopulation = newPopulation;
        }
    }
}
