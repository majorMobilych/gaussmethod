package simple;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class ThomasMethodDoubleImpl {

    private final double[][] aMatrix;
    private final double[] bVector;

    public double[] solve() {
        double[] xVector = new double[bVector.length+1];
        double[] p = p();
        double[] q = q(p);
        /* xVector[bVector.length] = 0;*/
        for (int i = bVector.length - 1; i > 0; i--) {
            xVector[i] = aMatrix[i - 1][i] / (-aMatrix[i - 1][i - 1] - aMatrix[i][i - 1] * p[i])*xVector[i+1]+(aMatrix[i][i - 1]*q[i]-bVector[i])/ (-aMatrix[i - 1][i - 1] - aMatrix[i][i - 1] * p[i]);
        }
        return xVector;
    }

    private double[] p() {
        double[] p = new double[bVector.length+2];
        for (int i = 2; i < bVector.length-1; i++) {
            p[i] = aMatrix[i - 1][i] / (-aMatrix[i - 1][i - 1] - aMatrix[i][i - 1] * p[i - 1]);
        }
        return p;
    }

    private double[] q(double[] p) {
        double[] q = new double[bVector.length+1];
        for (int i = 2; i < bVector.length-1; i++) {
            q[i] = (aMatrix[i][i - 1] * q[i - 1] - bVector[i - 1]) / (-aMatrix[i - 1][i - 1] - aMatrix[i][i - 1] * p[i - 1]);
        }
        return q;
    }
}
