package com.app.leetcode;

import com.app.Solution;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateStackSequences implements Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int pushIndex = 0, popIndex = 0;
        Deque<Integer> stack = new LinkedList<>();

        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }
        if (pushed.length != popped.length) {
            return false;
        }

        stack.push(pushed[pushIndex++]);
        while (!(stack.isEmpty() && pushIndex>=pushed.length && popIndex>=popped.length)) {
            if(canItemBePopped(stack, popped, popIndex)) {
                stack.pop();
                popIndex++;
                continue;
            }
            if (pushIndex < pushed.length) {
                stack.push(pushed[pushIndex++]);
            } else {
                return false;
            }
        }

        if(stack.isEmpty() && pushIndex == pushed.length && popIndex == popped.length) {
            return true;
        }
        return false;
    }

    private boolean canItemBePopped(Deque<Integer> stack, int[] popped, int popIndex) {
        if (popIndex < 0 || popIndex >= popped.length || stack.isEmpty()) {
            return false;
        }
        int item = popped[popIndex];
        return stack.peek().intValue() == item;
    }

    @Override
    public void execute() {
        //int[] pushed = {1,2,3,4,5};
        //int[] popped = {4,5,3,2,1};
        //int[] popped = {4,3,5,1,2};
        int[] pushed = {1,0};
        int[] popped = {1,0};
        System.out.println(validateStackSequences(pushed, popped));
    }
}
