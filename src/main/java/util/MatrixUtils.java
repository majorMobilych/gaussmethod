package util;

public final class MatrixUtils {

    private MatrixUtils() {
        throw new AssertionError("MatrixUtils.class - is an util class");
    }

    public static void exceptionsChecking(double[][] aMatrix, double[] bVector) {
        if (aMatrix.length != bVector.length) {
            throw new IllegalArgumentException("A matrix and B vector has incompatible heights");
        }

        if (aMatrix.length != aMatrix[0].length) {
            throw new IllegalArgumentException("A matrix should be of a square");
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + "\t");
            }

            System.out.print("\n");
        }
    }

    public static double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length;
        int m2RowLength = m2.length;

        if (m1ColLength != m2RowLength) {
            return null;
        }

        int mRRowLength = m1.length;
        int mRColLength = m2[0].length;
        double[][] mResult = new double[mRRowLength][mRColLength];

        for (int i = 0; i < mRRowLength; i++) {
            for (int j = 0; j < mRColLength; j++) {
                for (int k = 0; k < m1ColLength; k++) {
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        return mResult;
    }


    public static double[] multiplyByMatrix(double[][] m1, double[] m2) {
        double[] mResult = new double[m2.length];

        for (int i = 0; i < m1.length; i++) {
            for (int k = 0; k < m1[i].length; k++) {
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
