package util;

import lombok.AllArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class MatrixBuilder {

    private final int rows;
    private final int columns;

    //Хардкодим дефолтные значения для rows и columns
    public MatrixBuilder() {
        this.rows = 3;
        this.columns = 3;
    }

    public double[][] buildMatrix() {
        double[][] matrix = new double[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.printf("Input matrix[%d][%d]: ", i, j);
                matrix[i][j] = InputUtils.getDouble();
            }
        }
        return matrix;
    }

    public double[][] buildRandomlyGeneratedMatrix(int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) {
            throw new IllegalArgumentException("lowerBound must be greater then upperBound");
        }
        double[][] matrix = new double[this.rows][this.columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextDouble(lowerBound, upperBound);
            }
        }
        return matrix;
    }
}
