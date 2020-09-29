package util;

public final class MatrixUtils {

    private MatrixUtils() {
        throw new AssertionError("MatrixUtils - is an util class");
    }

    public static void printMatrix(double[][] matrix) {
        for(double[] row: matrix) {
            for (double element: row) {
                System.out.print(element + "\t");
            }
            System.out.print("\n");
        }
    }

    public static double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length; // m1 columns length
        int m2RowLength = m2.length;    // m2 rows length
        if (m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m1.length;    // m result rows length
        int mRColLength = m2[0].length; // m result columns length
        double[][] mResult = new double[mRRowLength][mRColLength];
        for (int i = 0; i < mRRowLength; i++) {         // rows from m1
            for (int j = 0; j < mRColLength; j++) {     // columns from m2
                for (int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }


    public static double[] multiplyByMatrix(double[][] m1, double[] m2) {
        double[] mResult = new double[m2.length];
        for (int i = 0; i < m1.length; i++) {         // rows from m1
            // columns from m2
            for (int k = 0; k < m1[i].length; k++) { // columns from m1
                mResult[i] += m1[i][k] * m2[k];
            }
        }
        return mResult;
    }


    public static double[] subtractVectors(double[] v2, double[] v1) {
        for (int i = 0; i < v2.length; i++) {
            v2[i] = v2[i] - v1[i];
        }
        return v2;
    }
}
