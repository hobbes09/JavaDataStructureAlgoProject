package com.app.twitter;

import com.app.BinaryHeap;
import com.app.Solution;
import java.util.*;


class TweetInfo {
    int tweetId;
    int frequency;
    int lastSeenIndex; //(?)

    public TweetInfo(int tweetId, int frequency, int lastSeenIndex) {
        this.tweetId = tweetId;
        this.frequency = frequency;
        this.lastSeenIndex = lastSeenIndex;
    }
}


public class TweetAnalysis implements Solution {

    Map<Integer,Integer> presentInHeap = new HashMap<>();

    PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a,b) -> presentInHeap.getOrDefault(b,0) - presentInHeap.getOrDefault(a,0));

    @Override
    public void execute() {

        int[] tweetIds = {5,7,5,7,4,5};
        topKFrequent(tweetIds);
        System.out.println(heap.peek());
        int[] tweetIds2 = {7,4,7};
        topKFrequent(tweetIds2);
        System.out.println(heap.peek());
    }

    public void topKFrequent(int[] nums) {


        for(int i=0;i<nums.length;i++){
            addInHeap(nums[i]);
        }
    }


    public void addInHeap(int element){

        if(presentInHeap.containsKey(element)){
            presentInHeap.put(element,presentInHeap.get(element)+1);
            heap.remove(element);
            heap.add(element);
        }else{
            presentInHeap.put(element, 1);
            heap.add(element);
        }
    }
}
