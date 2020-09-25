package advanced.lab.ct;

import advanced.common.AbstractGaussMethodBasicActionsSequence;

import java.util.Comparator;

/**
 * An abstract implementation if elements in the 'A' matrix are comparable
 *
 * @param <CT> comparable type
 * @param <B>  type of elements in the 'B' matrix
 * @author Goncharov Mikhail
 * @author Ternovoy Eugeniy
 * @version 1.0
 */
abstract class AbstractGaussMethodActionsSequenceForComparableTypes<CT, B> extends
        AbstractGaussMethodBasicActionsSequence<CT, B> {

    /**
     * Finds module-max element in the column
     *
     * @param aMatrix    'A' matrix
     * @param bMatrix    'B' matrix
     * @param comparator comparator for comparing type-A elements
     * @param colNum     number of column
     * @return number of row, where the max element is situated
     */
    int findNumberOfRowWithMaxFirstElement(CT[][] aMatrix, B[] bMatrix,
                                           Comparator<CT> comparator,
                                           int colNum) {
        int maxIndex = colNum;
        for (int i = colNum + 1; i < aMatrix.length; i++) {
            if (comparator.compare(aMatrix[i][colNum], aMatrix[maxIndex][colNum]) > 0) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Swaps a given row to another (where the max element in abstract column is situated)
     *
     * @param aMatrix     'A' matrix
     * @param bMatrix     'B' matrix
     * @param firstIndex  index of first row to swap
     * @param secondIndex index of second row to swap
     */
    void swapRows(CT[][] aMatrix, B[] bMatrix, int firstIndex, int secondIndex) {
        CT[] aTemp = aMatrix[firstIndex];
        aMatrix[firstIndex] = aMatrix[secondIndex];
        aMatrix[secondIndex] = aTemp;

        B bTemp = bMatrix[firstIndex];
        bMatrix[firstIndex] = bMatrix[secondIndex];
        bMatrix[secondIndex] = bTemp;
    }
}
