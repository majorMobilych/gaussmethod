package simple;

import lombok.*;

@AllArgsConstructor
@Data
public final class GaussMethodDoubleImpl {

    private double[][] aMatrix;
    private double[] bVector;

    private void exceptionsChecking() {
        if (aMatrix.length != bVector.length) {
            throw new IllegalArgumentException("A matrix and B vector has incompatible types");
        }
        if (aMatrix.length != aMatrix[0].length) {
            throw new IllegalArgumentException("A matrix should be of a square");
        }
    }

    public double[] solve() {
        exceptionsChecking();

        double[] x = new double[bVector.length];


        return x;
    }

    private void findRowWithMAxFirstElement() {

    }

    private void divideAllRowElementsByNumber(int rowNum, int colNum, int number) {
        for (int i = colNum; i < aMatrix.length; i++) {
            aMatrix[rowNum][i] = aMatrix[rowNum][i] / number;
        }
        //работаем с bVector
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
            //работаем с bVector
            bVector[i] = bVector[i] - bVector[rowNum] * multiplier;
        }

    }

    private void setZeroesUp() {

    }
}
