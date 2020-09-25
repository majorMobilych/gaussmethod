package advanced.lab.ct.impl;

import advanced.common.ArithmeticOperationsDefinition;
import advanced.lab.ct.GaussMethodActionsSequenceForComparableTypesABXArraySameType;

public class DoublesGaussMethod extends GaussMethodActionsSequenceForComparableTypesABXArraySameType<Double> {
    public DoublesGaussMethod() {
        super((aDouble, t1) -> (int) (aDouble - t1),

                new ArithmeticOperationsDefinition<>() {
                    @Override
                    public Double add(Double first, Double second) {
                        return first + second;
                    }

                    @Override
                    public Double subtract(Double first, Double second) {
                        return first - second;
                    }

                    @Override
                    public Double multiply(Double first, Double second) {
                        return first * second;
                    }

                    @Override
                    public Double divide(Double first, Double second) {
                        return first / second;
                    }
                }
        );
    }
}
