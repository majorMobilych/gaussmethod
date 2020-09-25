package util;

public final class MatrixUtils {

    private MatrixUtils() {
        throw new AssertionError("MatrixUtils - утильный класс");
    }

    public static void printMatrix(double[][] matrix) {
        for(double[] row: matrix) {
            for (double element: row) {
                System.out.print(element + "\t");
            }
            System.out.print("\n");
        }
    }
}
