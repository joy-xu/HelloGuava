package com.alibaba.basic;


import static com.google.common.base.Preconditions.*;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class PreconditionsClass {
    private String label;
    private int[] values = new int[5];
    private int currentIndex;

    public PreconditionsClass(String label) {
        //returns value of object if not null
        this.label = checkNotNull(label, "Label can't be null");
    }

    public void updateCurrentIndexValue(int index, int valueToSet) {
        //Check index valid first
        this.currentIndex = checkElementIndex(index, values.length,
                "Index out of bounds for values");
            //Validate valueToSet
        checkArgument(valueToSet <= 100, "Value can't be more than 100");
                values[this.currentIndex] = valueToSet;
    }

    public void doOperation() {
        checkState(validateObjectState(), "Can't perform operation");
    }

    private boolean validateObjectState() {
        return this.label.equalsIgnoreCase("open") && values[this.
                currentIndex] == 10;
    }
}
