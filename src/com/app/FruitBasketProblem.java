package com.app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FruitBasketProblem implements Solution {

    @Override
    public void execute() {

//        int[] trees = {3,3,3,1,2,1,1,2,3,3,4};
//        HashMap<Integer, Integer> baskets = new HashMap<>(2);
//        Integer prevFruitType = trees[0];
//        Integer prevFruitCount = 1;
//        int maxFruits = 2;
//        baskets.put(trees[0], baskets.get(trees[0]) + 1);
//        baskets.put(trees[1], baskets.get(trees[1]) + 1);
//
//        int current = 1;
//        while (left <= trees.length-1 && right <= trees.length-1) {
//
//            int newFruit = trees[right];
//            if (canAddNewFruitInExistingBasket(newFruit, baskets)) {
//
//            } else {
//
//            }
//            maxFruits = recordNewBasketStatus(baskets);
//        }

    }

    private int recordNewBasketStatus(HashMap<Integer, Integer> baskets) {
        return 1;
    }

    private boolean canAddNewFruitInExistingBasket(int newFruit, HashMap<Integer, Integer> baskets) {
        return true;
    }
}
