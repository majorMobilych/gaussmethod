import simple.ThomasMethodDoubleImpl;

public class Starter {
    public static void main(String[] args) {
        var aMatrix = new double[][]{
                {
                        1.0, 1.0, 0.0, 0.0
                },
                {
                        1.0, 1.0, 5.6, 0.0
                },
                {
                        0.0, 1.2, 3.2, 4.5
                },
                {
                        0.0, 0.0, 1.0, 1.0
                }
        };
        double[] bVector = new double[] {1.0 ,1.0, 1.0, 1.0};
        ThomasMethodDoubleImpl thomasMethodDoubleImpl = new ThomasMethodDoubleImpl(aMatrix, bVector);
        thomasMethodDoubleImpl.solve();
    }

}
