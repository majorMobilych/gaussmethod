package advanced.common;

/**
 * Root interface for all GaussMethod implementations
 * <p>The vector equation of system of linear equations is:</p>
 * <p>AX = B;</p>
 * <p>
 *
 * @param <X> type of answer
 * @param <A> type of elements in matrix 'A'
 * @param <B> type of elements in matrix 'B'
 * @author Goncharov Mikhail
 * @author Ternovoy Eugeniy
 * @version 1.0
 */
public interface GaussMethod<X, A, B> {

    /**
     * Solves the system of linear equations by given matrices 'A' and 'B'
     *
     * @param aMatrix the 'A' matrix
     * @param bMatrix the 'B' matrix
     * @return answer
     * @throws IllegalArgumentException if number of rows in 'A' isn't equal to number of rows in 'B'
     */
    X solve(A[][] aMatrix, B[] bMatrix) throws IllegalArgumentException;

}
