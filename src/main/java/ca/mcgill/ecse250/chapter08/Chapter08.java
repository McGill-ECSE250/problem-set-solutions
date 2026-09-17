package ca.mcgill.ecse250.chapter08;


import java.util.Scanner;
/**
 * CHAPTER 8: MULTIDIMENSIONAL ARRAYS
 */
public class Chapter08 {
    private static final Scanner inputScanner = new Scanner(System.in);
    public static void main(String[] args) {
        inputScanner.close();
    }

    // EXERCISE 8.1 SUM ELEMENTS COLUMN BY COLUMN
    private final static byte NUM_OF_ROWS = 3;
    private final static byte NUM_OF_COLUMNS = 4;
    static void exercise_08_01() {
        double[][] matrix = new double[NUM_OF_ROWS][NUM_OF_COLUMNS];
        System.out.println("Enter a 3-by-4 matrix row by rom: ");
        for(byte i = 0; i < NUM_OF_ROWS; i++) {
            String numbersSeparatedBySpace = inputScanner.nextLine();
            String[] numbersInString = numbersSeparatedBySpace.split(" ");
            for(int j = 0; j < NUM_OF_COLUMNS; j++) {
                matrix[i][j] = Double.parseDouble(numbersInString[j]);
            }
        }
        for(byte i = 0; i < NUM_OF_COLUMNS; i++) {
            System.out.println("Sum of the elements at column " + i + " is " + sumColumn(matrix, i));
        }

    }
    public static double sumColumn(double[][] m, int columnIndex){
        double sum = 0;
        for(int i = 0; i < m.length; i++) {
            sum += m[i][columnIndex];
        }
        return sum;
    }

    // EXERCISE 8.5: Algebra: add to matrices
    private final static byte MATRIX_SIZE = 3;

    static void exercise_08_05() {
        double[][] matrix1 = new double[MATRIX_SIZE][MATRIX_SIZE];
        double[][] matrix2 = new double[MATRIX_SIZE][MATRIX_SIZE];
        String addOperation = "+";
        GetMatricesFromConsole(matrix1, matrix2);
        double[][] matrixSum = addMatrix(matrix1, matrix2);

        System.out.println("the addition of the matrices is\n"
                + stringFormatMatrixEquation(matrix1, matrix2, matrixSum, addOperation));
    }

    private static void GetMatricesFromConsole(double[][] matrix1, double[][] matrix2) {
        final String addOperation = "+";

        System.out.println("Enter matrix1: ");
        String matrix1String = inputScanner.nextLine();

        System.out.println("Enter matrix2: ");
        String matrix2String = inputScanner.nextLine();

        parseStringToDoubleMatrix(matrix1String, matrix1);
        parseStringToDoubleMatrix(matrix2String, matrix2);
    }


    private static final byte MATRIX_SPACING = 5;
    private static String stringFormatMatrixEquation(double[][] matrix1, double[][] matrix2
                                                    , double[][] matrixResult, String operationString) {
        if(matrix1 == null || matrix2 == null || matrixResult == null || matrix1.length != matrix2.length || matrix1.length != matrixResult.length) {
            return "";
        }
        String formattedString = "";
        for(int i = 0; i < matrix1.length; i++) {
            for(int j = 0; j < matrix1[i].length; j++) {
                formattedString += matrix1[i][j] + " ";
            }
            formattedString += (matrix1.length / 2 == i) ? " ".repeat(MATRIX_SIZE / 2) + operationString + " ".repeat(MATRIX_SIZE / 2) : " ".repeat(MATRIX_SIZE);
            for(int j = 0; j < matrix2[i].length; j++) {
                formattedString += matrix2[i][j] + " ";
            }
            formattedString += (matrix1.length / 2 == i) ? " ".repeat(MATRIX_SIZE / 2) + "=" + " ".repeat(MATRIX_SIZE / 2) : " ".repeat(MATRIX_SIZE);
            for(int j = 0; j < matrixResult[i].length; j++) {
                formattedString += matrixResult[i][j] + " ";
            }
            formattedString += "\n";
            //formattedString += matrix1[i][0] + " ".repeat(MATRIX_SPACING) + matrix2[i][0] + " ".repeat(MATRIX_SPACING) + matrixResult[i][0];
        }
        return formattedString;
    }

    // Assuming that the matrix row x column <= matrixString.split(" ").length
    private static void parseStringToDoubleMatrix(String matrixString, double[][] matrix) {
        String[] matrix1StringArray = matrixString.split(" ");
        byte index1DArray = 0;
        for(byte i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Double.parseDouble(matrix1StringArray[index1DArray++]);
            }
        }
    }

    public static double[][] addMatrix(double[][] a, double[][] b){
        if(a == null || b == null || a.length != b.length || a.length == 0){
            return null;
        }
        double[][] c = new double[a.length][b[0].length];
        for (int row = 0; row < a.length; row++) {
            if (a[row] == null || b[row] == null || a[row].length != b[row].length || a[row].length == 0){
                return null;
            }
            for (int column = 0; column < a[row].length; column++) {
                c[row][column] = a[row][column] + b[row][column];
            }
        }
        return c;
    }

    // EXERCISE 8.29: IDENTICAL ARRAYS
    static void exercise_08_29() {
        System.out.println("Enter matrix1: ");
        String matrix1String = inputScanner.nextLine();
        int[][] matrix1 = new int[MATRIX_SIZE][MATRIX_SIZE];
        System.out.println("Enter matrix2: ");
        String matrix2String = inputScanner.nextLine();
        int[][] matrix2 = new int[MATRIX_SIZE][MATRIX_SIZE];
        parseStringToIntMatrix(matrix1String, matrix1);
        parseStringToIntMatrix(matrix2String, matrix2);
        System.out.println("The two arrays are" + (equals(matrix1, matrix2) ? " " : " not ") + "identical");
    }
    private static void parseStringToIntMatrix(String matrixString, int[][] matrix) {
        String[] matrix1StringArray = matrixString.split(" ");
        byte index1DArray = 0;
        for(byte i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(matrix1StringArray[index1DArray++]);
            }
        }
    }
    public static boolean equals(int[][] m1, int[][] m2){
        if ((m1 == null) || (m2 == null) || m1.length != m2.length){
            return (m1 == null && m2 == null);
        }
        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length){
                return false;
            }
            for (int j = 0; j < m2[i].length; j++) {
                if (m1[i][j] != m2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
