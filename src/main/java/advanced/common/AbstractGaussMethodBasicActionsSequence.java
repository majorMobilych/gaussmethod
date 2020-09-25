package advanced.common;

/**
 * Interface defines basic sequence of actions, used in Gauss method
 *
 * @param <A> type of elements in the 'A' matrix
 * @param <B> type of elements in the 'B' matrix
 * @author Goncharov Mikhail
 * @author Ternovoy Eugeniy
 * @version 1.0
 */
public abstract class AbstractGaussMethodBasicActionsSequence<A, B> {

    /**
     * Divides all elements in the augmented matrix by a number from the 'A' matrix
     *
     * @param aMatrix      the 'A' matrix
     * @param bMatrix      the 'B' matrix
     * @param rowNum       number of row
     * @param givenNumber  given number, typed to A, because it is taken form the 'A' matrix
     * @param arithmeticAA arithmetic actions executor over A and A types
     * @param arithmeticBA arithmetic actions executor over B and A types
     */
    protected void divideAllElementsOfRowByAGivenNumber(A[][] aMatrix, B[] bMatrix,
                                                        int rowNum, int startingColNum,
                                                        A givenNumber,
                                                        ArithmeticOperationsDefinition<A, A, A> arithmeticAA,
                                                        ArithmeticOperationsDefinition<B, A, B> arithmeticBA) {
        /* Get number of columns (length of row) */
        int rowLength = aMatrix[rowNum].length;

        /* Starting from ith element in row{nowNum}, divides all elements of this row by a given number */
        for (int i = startingColNum; i < rowLength; i++) {
            aMatrix[rowNum][i] = arithmeticAA.divide(aMatrix[rowNum][i], givenNumber);
        }

        /* Divide rowNum element of the bMatrix by a given number */
        bMatrix[rowNum] = arithmeticBA.divide(bMatrix[rowNum], givenNumber);
    }

    /**
     * Sets all element in the jth column under the ith row to zeroes
     *
     * @param aMatrix      the 'A' matrix
     * @param bMatrix      the'B' matrix
     * @param rowNum       number of row
     * @param colNum       number of column
     * @param arithmeticAA arithmetic actions executor over A and A types
     * @param arithmeticBA arithmetic actions executor over B and A types
     * @param arithmeticBB arithmetic actions executor over B and B types
     */
    protected void setZerosUnder(A[][] aMatrix, B[] bMatrix,
                                 int rowNum, int colNum,
                                 ArithmeticOperationsDefinition<A, A, A> arithmeticAA,
                                 ArithmeticOperationsDefinition<B, A, B> arithmeticBA,
                                 ArithmeticOperationsDefinition<B, B, B> arithmeticBB) {
        /* Get number of rows (length of column) */
        int columnLength = aMatrix.length;

        /* Set zeroes in the colNum 'th column after rowNum 'th element */
        for (int i = rowNum + 1; i < columnLength; i++) {

            A aElement = aMatrix[i][colNum];
            //TODO: ПРОЧЕКАТЬ
            for (int j = colNum; j < columnLength + 1; j++) {
                aMatrix[i][j] = arithmeticAA.subtract(
                        aMatrix[i][j],
                        arithmeticAA.multiply(aMatrix[rowNum][j], aElement)
                );
            }

            B bElement = bMatrix[rowNum];
            bMatrix[i] = arithmeticBB.subtract(
                    bMatrix[i],
                    arithmeticBA.multiply(bElement, aElement)
            );
        }
    }

    /**
     * Sets all element in the jth column above the ith row to zeroes
     *
     * @param aMatrix      the 'A' matrix
     * @param bMatrix      the'B' matrix
     * @param rowNum       number of row
     * @param colNum       number of column
     * @param arithmeticAA arithmetic actions executor over A and A types
     * @param arithmeticBA arithmetic actions executor over A and B types
     */
    protected void setZeroesUp(A[][] aMatrix, B[] bMatrix,
                            int rowNum, int colNum,
                            ArithmeticOperationsDefinition<A, A, A> arithmeticAA,
                            ArithmeticOperationsDefinition<B, A, B> arithmeticBA,
                            ArithmeticOperationsDefinition<B, B, B> arithmeticBB) {

        /* Get number of rows (length of column) */
        int columnLength = aMatrix.length;

        /* Set zeroes in the colNum 'th column after rowNum 'th element */
        //TODO: ПРОЧЕКАТЬ
        for (int i = rowNum - 1; i > 0; i--) {

            A aElement = aMatrix[i][colNum];
            for (int j = colNum; j < columnLength + 1; j++) {
                aMatrix[i][j] = arithmeticAA.subtract(
                        aMatrix[i][j],
                        arithmeticAA.multiply(aMatrix[rowNum][j], aElement)
                );
            }

            B bElement = bMatrix[rowNum];
            bMatrix[i] = arithmeticBB.subtract(
                    bMatrix[i],
                    arithmeticBA.multiply(bElement, aElement)
            );
        }
    }
}

