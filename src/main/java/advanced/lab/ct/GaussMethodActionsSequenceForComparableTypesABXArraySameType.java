package advanced.lab.ct;

import advanced.common.ArithmeticOperationsDefinition;
import advanced.common.GaussMethod;

import java.util.Comparator;

public class GaussMethodActionsSequenceForComparableTypesABXArraySameType<CT> extends
        AbstractGaussMethodActionsSequenceForComparableTypes<CT, CT> implements GaussMethod<CT[], CT, CT> {

    private final Comparator<CT> ctComparator;
    private final ArithmeticOperationsDefinition<CT, CT, CT> arithmeticCTCT;

    public GaussMethodActionsSequenceForComparableTypesABXArraySameType(
            Comparator<CT> ctComparator,
            ArithmeticOperationsDefinition<CT, CT, CT> arithmeticCTCT) {
        this.ctComparator = ctComparator;
        this.arithmeticCTCT = arithmeticCTCT;
    }

    @Override
    public CT[] solve(CT[][] aMatrix, CT[] bMatrix) throws IllegalArgumentException {
        if (aMatrix.length != bMatrix.length) {
            throw new IllegalArgumentException("Incompatible matrices length");
        }

        int matrixLength = aMatrix.length;
        for (int i = 0; i < matrixLength; i++) {
            swapRows(aMatrix, bMatrix, i, findNumberOfRowWithMaxFirstElement(aMatrix, bMatrix, ctComparator, i));
            divideAllElementsOfRowByAGivenNumber(
                    aMatrix, bMatrix,
                    i, i,
                    aMatrix[i][i],
                    arithmeticCTCT,
                    arithmeticCTCT
            );
            setZerosUnder(
                    aMatrix, bMatrix,
                    i, i,
                    arithmeticCTCT,
                    arithmeticCTCT,
                    arithmeticCTCT
            );
        }

        return bMatrix;
    }
}
