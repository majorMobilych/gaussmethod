package simple;

import util.MatrixUtils;

public final class GaussMethodDoubleImpl {

    private double[][] aMatrix;

    private double[] bVector;

    public GaussMethodDoubleImpl(double[][] aMatrix, double[] bVector) {
        this.aMatrix = aMatrix.clone();
        this.bVector = bVector.clone();
    }

    public double[] solve() {
        MatrixUtils.exceptionsChecking(aMatrix, bVector);

        for (int i = 0; i < bVector.length; i++) {
            swapRows(i, findNumberOfRowWithMaxFirstElement(i));
            divideAllRowElementsByNumber(i, i, aMatrix[i][i]);
            setZeroesUnder(i, i);
        }

        for (int i = bVector.length - 1; i >= 0; i--) {
            setZerosUp(i, i);
        }

        return bVector;
    }

    private int findNumberOfRowWithMaxFirstElement(int colNum) {
        if (colNum == bVector.length) {
            return colNum;
        }

        int maxIndex = colNum;

        for (int i = colNum + 1; i < aMatrix.length; i++) {
            if (Math.abs(aMatrix[i][colNum]) > Math.abs(aMatrix[maxIndex][colNum])) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void divideAllRowElementsByNumber(int rowNum, int colNum, double number) {
        for (int i = colNum; i < aMatrix.length; i++) {
            aMatrix[rowNum][i] = aMatrix[rowNum][i] / number;
        }

        bVector[rowNum] = bVector[rowNum] / number;
    }

    private void setZeroesUnder(int rowNum, int colNum) {
        final int aMatrixLength = aMatrix.length;

        if (rowNum == aMatrixLength) {
            return;
        }

        for (int i = rowNum + 1; i < aMatrixLength; i++) {
            double multiplier = aMatrix[i][colNum];

            for (int j = colNum; j < aMatrixLength; j++) {
                aMatrix[i][j] = aMatrix[i][j] - multiplier * aMatrix[rowNum][j];
            }

            bVector[i] = bVector[i] - bVector[rowNum] * multiplier;
        }
    }

    private void setZerosUp(int rowNum, int colNum) {
        int matrixLength = aMatrix.length;

        for (int i = rowNum; i > 0; i--) {
            double alpha = aMatrix[i - 1][colNum];

            for (int j = matrixLength - 1; j > colNum - 1; j--) {
                aMatrix[i - 1][j] = aMatrix[i - 1][j] - aMatrix[rowNum][j] * alpha;
            }

            bVector[i - 1] = bVector[i - 1] - bVector[rowNum] * alpha;
        }
    }

    private void swapRows(int currentIndex, int maxIndex) {
        double[] tempA = aMatrix[currentIndex];
        aMatrix[currentIndex] = aMatrix[maxIndex];
        aMatrix[maxIndex] = tempA;

        double tempB = bVector[currentIndex];
        bVector[currentIndex] = bVector[maxIndex];
        bVector[maxIndex] = tempB;
    }
}
