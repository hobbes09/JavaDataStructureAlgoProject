package com.app.leetcode;

import com.app.Solution;

import java.util.PriorityQueue;

public class DraftCode implements Solution {

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    @Override
    public void execute() {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> {
            return l1.val - l2.val;
        });


    }
}
