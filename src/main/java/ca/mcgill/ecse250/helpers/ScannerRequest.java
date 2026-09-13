package ca.mcgill.ecse250.helpers;

import java.util.Scanner;

public class ScannerRequest{
    private static final Scanner inputScanner = new Scanner(System.in);



    public static int getIntScannerRequest(String message) {
        System.out.println(message);
        return inputScanner.nextInt();
    }

    public static String getStringScannerRequest(String message) {
        System.out.println(message);
        return inputScanner.next();
    }

    public static boolean getBoolScannerRequest(String message) {
        System.out.println(message);
        return inputScanner.nextBoolean();
    }

    public static float getFloatScannerRequest(String message) {
        System.out.println(message);
        return inputScanner.nextFloat();
    }

    public static double getDoubleScannerRequest(String message) {
        System.out.println(message);
        return inputScanner.nextDouble();
    }



}
