package simple;

import util.MatrixUtils;

public final class ThomasMethodDoubleImpl {

    private final double[][] aMatrix;

    private final double[] bVector;

    private final double[] aArray;

    private final double[] bArray;

    private final double[] cArray;

    private final double[] xVector;

    public ThomasMethodDoubleImpl(double[][] aMatrix, double[] bVector) {
        this.aMatrix = aMatrix.clone();
        this.bVector = bVector.clone();
        this.aArray = aArrayCreate();
        this.bArray = bArrayCreate();
        this.cArray = cArrayCreate();
        this.xVector = new double[aMatrix.length];
    }


    public double[] solve() {
        MatrixUtils.exceptionsChecking(aMatrix, bVector);
        double m;
        for (int i = 1; i < aMatrix.length; i++) {
            m = cArray[i - 1] / aArray[i - 1];
            aArray[i] = aArray[i] - m * bArray[i - 1];
            bVector[i] = bVector[i] - m * bVector[i - 1];
        }

        xVector[aMatrix.length - 1] = bVector[aMatrix.length - 1] / aArray[aMatrix.length - 1];

        for (int i = aMatrix.length - 2; i >= 0; i--) {
            xVector[i] = (bVector[i] - bArray[i] * xVector[i + 1]) / aArray[i];
        }
        return xVector;
    }

    private double[] aArrayCreate() {
        double[] a = new double[aMatrix.length];
        for (int i = 0; i < aMatrix.length; i++) {
            a[i] = aMatrix[i][i];
        }
        return a;
    }

    private double[] bArrayCreate() {
        double[] b = new double[aMatrix.length - 1];
        for (int i = 0; i < aMatrix.length - 1; i++) {
            b[i] = aMatrix[i][i + 1];
        }
        return b;
    }

    private double[] cArrayCreate() {
        double[] c = new double[aMatrix.length - 1];
        for (int i = 0; i < aMatrix.length - 1; i++) {
            c[i] = aMatrix[i + 1][i];
        }
        return c;
    }
}