package advanced.common;

/**
 * Define basic arithmetic operations for types 'F' and 'S'
 *
 * @param <F> type of first parameter
 * @param <S> type of second parameter
 * @param <Wrapper> wrapping type of A and B
 * @author Goncharov Mikhail
 * @author Ternovoy Evgeniy
 * @version 1.0
 */
public interface ArithmeticOperationsDefinition<F, S, Wrapper> {

    /**
     * Method, defining addition of types 'F' and 'S'
     *
     * @return result of addition
     */
    Wrapper add(F first, S second);

    /**
     * Method, defining subtraction of types 'F' and 'S'
     *
     * @return result of subtraction
     */
    Wrapper subtract(F first, S second);

    /**
     * Method, defining multiplication of types 'F' and 'S'
     *
     * @return result of multiplication
     */
    Wrapper multiply(F first, S second);

    /**
     * Method, defining division of types 'F' and 'S'
     *
     * @return result of division
     */
    Wrapper divide(F first, S second);
}
