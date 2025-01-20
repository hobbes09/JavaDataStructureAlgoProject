package com.app.leetcode;

import com.app.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitBasketProblem implements Solution {

    @Override
    public void execute() {

        int[] trees = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(trees));

    }

    public int totalFruit(int[] fruits) {
        // We use a hash map 'basket' to store the number of each type of fruit.
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, maxPicked = 0;

        // Add fruit from the right index (right) of the window.
        for (int right = 0; right < fruits.length; ++right) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // If the current window has more than 2 types of fruit,
            // we remove fruit from the left index (left) of the window,
            // until the window has only 2 types of fruit.
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0)
                    basket.remove(fruits[left]);
                left++;
            }

            // Update maxPicked.
            maxPicked = Math.max(maxPicked, right - left + 1);
        }

        // Return maxPicked as the maximum number of fruits we can collect.
        return maxPicked;
    }

    private int recordNewBasketStatus(HashMap<Integer, Integer> baskets) {
        return 1;
    }

    private boolean canAddNewFruitInExistingBasket(int newFruit, HashMap<Integer, Integer> baskets) {
        return true;
    }
}
