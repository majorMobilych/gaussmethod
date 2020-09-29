import simple.GaussMethodDoubleImpl;
import util.MatrixUtils;

public class Starter {
    public static void main(String[] args) {
        double[][] aMatrix = new double[][]{
                {
                        2.0, 5.0, 7.0, 11.0
                },
                {
                        99.0, 22.0, 75.0, 66.0
                },
                {
                        223.0, 228.0, 12.0, 9.0
                },
                {
                        4.0, 3.0, 2.0, 1.0
                }
        };
        double[] xVector = new double[]{1.0, 1.0, 1.0, 1.0};
        double[] bVector;
        bVector = MatrixUtils.multiplyByMatrix(aMatrix, xVector);
        GaussMethodDoubleImpl solver = new GaussMethodDoubleImpl(aMatrix, bVector);
        double[] doubles = MatrixUtils.subtractVectors(solver.solve(), xVector);
        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }
}
