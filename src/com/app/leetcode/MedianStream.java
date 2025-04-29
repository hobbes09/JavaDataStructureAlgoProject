package com.app.leetcode;

import com.app.Solution;

import java.util.*;

public class MedianStream implements Solution {
    
    PriorityQueue<Integer> maxHeap; // Contains the lower half of elements
    PriorityQueue<Integer> minHeap; // Contains the upper half of elements
    
    int countMinHeap, countMaxHeap;

    @Override
    public void execute() {
        
        maxHeap = new PriorityQueue<>((a,b)->{return b-a;});
        minHeap = new PriorityQueue<>((a,b)->{return a-b;});
        countMaxHeap = 0;
        countMinHeap = 0;

        addElementToStream(12);
        addElementToStream(10);
        addElementToStream(8);
        addElementToStream(7);
        addElementToStream(15);
        addElementToStream(34);
        addElementToStream(45);
        addElementToStream(56);
        printMedianElementOfStream();
    }
    
    private void addElementToStream(int elem){
        if (countMaxHeap == 0) {
            addElemToLowerHalfAndRebalance(elem);
            return;
        }

        if (elem <= maxHeap.peek()) {
            addElemToLowerHalfAndRebalance(elem);
        } else {
            addElemToUpperHalfAndRebalance(elem);
        }
        
    }

    private void addElemToUpperHalfAndRebalance(int elem) {
        minHeap.add(elem);
        countMinHeap++;
        while (countMinHeap - countMaxHeap > 1) {
            int minElemToBeShifted = minHeap.poll();
            countMinHeap--;
            maxHeap.add(minElemToBeShifted);
            countMaxHeap++;
        }

    }

    private void addElemToLowerHalfAndRebalance(int elem) {
        maxHeap.add(elem);
        countMaxHeap++;
        while (countMaxHeap - countMinHeap > 1) {
            int maxElemToBeShifted = maxHeap.poll();
            countMaxHeap--;
            minHeap.add(maxElemToBeShifted);
            countMinHeap++;
        }
    }


    private void printMedianElementOfStream(){
        if (countMaxHeap > countMinHeap) {
            System.out.println("Median :: " + maxHeap.peek());
        } else if (countMaxHeap < countMinHeap) {
            System.out.println("Median :: " + minHeap.peek());
        } else {
            System.out.println("Median :: " + ((maxHeap.peek() + minHeap.peek())/2));
        }
    }
    
    
}
