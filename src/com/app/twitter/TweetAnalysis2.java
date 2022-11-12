package com.app.twitter;

import com.app.Solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TweetAnalysis2 implements Solution {

    HashMap<Integer, TweetInfo> mapTweets = new HashMap<>();

    PriorityQueue<Integer> maxHeapTweets = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer t1, Integer t2) {
            TweetInfo ot1 = mapTweets.get(t1);
            TweetInfo ot2 = mapTweets.get(t2);
            return ot2.frequency == ot1.frequency ? ot2.lastSeenIndex - ot1.lastSeenIndex : ot2.frequency - ot1.frequency;
        }
    });

    @Override
    public void execute() {

        int[] tweetIds = {5,7,5,7,4,5};
        addTweetIds(tweetIds);
        System.out.println(maxHeapTweets.peek());
        tweetIds = new int[]{7,4,7};
        addTweetIds(tweetIds);
        System.out.println(maxHeapTweets.peek());
    }

    public void addTweetIds(int[] tweetIds) {

        for (int i=0; i<tweetIds.length; i++) {
            TweetInfo tweetInfo;
            if (mapTweets.containsKey(tweetIds[i])) {
                tweetInfo = mapTweets.get(tweetIds[i]);
                maxHeapTweets.remove(tweetIds[i]);
                tweetInfo.frequency +=1;
                tweetInfo.lastSeenIndex = i;
            } else {
                tweetInfo = new TweetInfo(tweetIds[i], 1, i);
                mapTweets.put(tweetIds[i], tweetInfo);
            }
            maxHeapTweets.add(tweetInfo.tweetId);
        }
    }
}
