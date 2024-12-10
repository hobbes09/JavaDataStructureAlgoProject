package com.app;

/*

Given two positive numbers as strings. The numbers may be very large (may not fit in long long int),
the task is to find product of these two numbers.

Examples:
Input : num1 = 4154
        num2 = 51454
Output : 213739916

Input :  num1 = 654154154151454545415415454
         num2 = 63516561563156316545145146514654

Output : 41549622603955309777243716069997997007620439937711509062916

 */

public class CourseHeroApp implements Solution {

    public String largeMultiplier(String num1, String num2) {

        String output = "";

        if (isEitherZero(num1, num2))
            return "";

        int[] pdtArr = new int[num1.length() + num2.length()+1];
        for (int firstIndex = 0; firstIndex < num1.length(); firstIndex++) {
            int carryOver = 0;
            int offset = getOffsetForIndex(firstIndex);
            int numAtFirstIndex = getNumAtIndexFromUnit(num1, firstIndex);
            for (int secIndex = 0; secIndex<num2.length(); secIndex++) {
                int numAtSecIndex = getNumAtIndexFromUnit(num2, secIndex);
                int res = numAtFirstIndex*numAtSecIndex + carryOver;
                carryOver = updateProductResult(pdtArr, secIndex, res, offset, false);
            }
            updateProductResult( pdtArr, num2.length()-1, carryOver, offset, true);
        }

        return output;
    }

    private int updateProductResult(int[] pdtArr, int indexForUpdate, int valueToAdd, int offsetInIndex, boolean withoutReturnFlag) {
        int carryOver = 0;
        pdtArr[offsetInIndex+indexForUpdate] += valueToAdd;
        if (pdtArr[offsetInIndex+indexForUpdate] > 9) {
            int temp = pdtArr[offsetInIndex+indexForUpdate];
            pdtArr[offsetInIndex+indexForUpdate] = temp % 10;
            carryOver = temp / 10;
            if (!withoutReturnFlag) {
                pdtArr[offsetInIndex+indexForUpdate+1] = carryOver;
            }
        }
        return carryOver;
    }

    private int getOffsetForIndex(int firstIndex) {
        return firstIndex;
    }

    private int getNumAtIndexFromUnit(String num, int index) {
        int len = num.length();
        char numChar = num.charAt(len - 1 - index);
        return Integer.parseInt(numChar+"");
    }

    private boolean isEitherZero(String num1, String num2) {
        return false; // TODO
    }

    @Override
    public void execute() {
        largeMultiplier("41", "5");
    }
}
