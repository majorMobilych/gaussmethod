package simple;

import util.MatrixUtils;
import util.VectorBuilder;

public final class SimpleIterationsDoublesImpl {

    private double[][] aMatrix;

    private double[] bVector;

    private double epsilon;

    public SimpleIterationsDoublesImpl(double[][] aMatrix, double[] bVector, double epsilon) {
        this.aMatrix = aMatrix.clone();
        this.bVector = bVector.clone();
        this.epsilon = epsilon;
    }

    public double[] solve() {
        MatrixUtils.exceptionsChecking(aMatrix, bVector);

        final int size = bVector.length;
        double[] previousVariableValues = VectorBuilder.buildVectorOfZeros(size);

        while (true) {
            double[] currentVariableValues = VectorBuilder.buildVectorOfZeros(size);

            for (int i = 0; i < size; i++) {
                currentVariableValues[i] = bVector[i];

                for (int j = 0; j < size; j++) {
                    if (i != j) {
                        currentVariableValues[i] -= aMatrix[i][j] * previousVariableValues[j];
                    }
                }
                currentVariableValues[i] /= aMatrix[i][i];
            }

            double error = 0.0;

            for (int i = 0; i < size; i++) {
                error += Math.abs(currentVariableValues[i] - previousVariableValues[i]);
            }

            if (error < epsilon) {
                break;
            }

            previousVariableValues = currentVariableValues;
        }

        return previousVariableValues;
    }

}

