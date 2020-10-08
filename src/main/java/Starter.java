import simple.SimpleIterationsDoublesImpl;

public class Starter {
    public static void main(String[] args) {
        double[][] aMatrix = new double[][]{
                {0.05, -0.06, -0.12, 0.14},
                {0.04, -0.12, 0.68, 0.11},
                {0.34, 0.08, -0.06, 0.44},
                {0.11, 0.12, -0.03, -0.8}
        };
        double[] bVector = new double[]{1.0, 1.0, 1.0, 1.0};
        double epsilon = 0.01;
        SimpleIterationsDoublesImpl simpleIterationsDoubles = new SimpleIterationsDoublesImpl(aMatrix, bVector, epsilon);
        simpleIterationsDoubles.solve();
    }
}
