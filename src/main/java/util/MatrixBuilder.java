package util;

import java.util.concurrent.ThreadLocalRandom;

public final class MatrixBuilder {

    private MatrixBuilder(int rows, int columns) {
        throw new AssertionError("MatrixBuilder.class is an util class");
    }

    public double[][] buildMatrix(int rows, int columns) {
        double[][] matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("Input matrix[%d][%d]: ", i, j);
                matrix[i][j] = InputUtils.getDouble();
            }
        }

        return matrix;
    }

    public static double[][] buildRandomlyGeneratedMatrix(int rows, int columns, double lowerBound, double upperBound) {
        double[][] matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextDouble(lowerBound, upperBound);
            }
        }
        return matrix;
    }

    public static double[][] buildRandomlyGeneratedMatrix(int rows, int columns) {
        return buildRandomlyGeneratedMatrix(rows, columns, -10.0, 10.0);
    }

    public static double[][] buildRandomlyGeneratedMatrixWithBiggerDiagElements(int rows, int columns) {
        double[][] matrix = new double[rows][columns];
        double maxElement = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i != j) {
                    matrix[i][j] = ThreadLocalRandom.current().nextDouble(0, 1);
                } else {
                    matrix[i][j] = ThreadLocalRandom.current().nextDouble(0, 1) + 1000;
                    if (maxElement < matrix[i][j]) maxElement = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = matrix[i][j] / maxElement;
            }
        }

        return matrix;
    }

    public static double[][] buildRandomlyGeneratedTripleDiagMatrix(int rows, int columns) {
        double[][] matrix = new double[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j || i == j - 1 || i == j + 1) {
                    matrix[i][j] = ThreadLocalRandom.current().nextDouble(-10, 10);
                }
            }
        }

        return matrix;
    }
}

