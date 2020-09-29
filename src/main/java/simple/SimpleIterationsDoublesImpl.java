package simple;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SimpleIterationsDoublesImpl {

    private final double epsilon;
    private double[][] masA;
    double[] bVector;

    public void solve() {
        final int length = bVector.length;

        double[] x = new double[length];
        double[] x0 = new double[length];
        double[] E = new double[length];
        double max;
        System.arraycopy(bVector, 0, x0, 0, length);

        int counter = 0;
        do {
            for (int i = 0; i < length; i++) {
                x[i] = 0;
                for (int j = 0; j < length; j++) {
                    x[i] += masA[i][j] * x0[j];
                }
                x[i] += bVector[i];
                //ТОЧНО FABS = MATH.ABS() ?
                E[i] = Math.abs(x[i] - x0[i]);
            }
            max = 0;
            int i;
            for (i = 0; i < length; i++) {
                if (max < E[i]) max = E[i];
                x0[i] = x[i];
            }
            counter++;
        } while (max > epsilon);

        System.out.println("Количество итераций: " + counter);
        for (int i = 0; i < length; i++) {
            System.out.println("x" + (i + 1) + "=" + x[i]);
        }
    }
}

