package com.app.leetcode;

import com.app.Solution;

public class ReverseLinkedListByKNodes implements Solution {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public boolean hasNext() {
            return next != null;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    // 1>2>3>4>5
    //
    ListNode reverseLinkedList(ListNode head) {

        ListNode curr, next, nNext;
        curr = head;
        next = curr.next;
        curr.next = null;

        while (curr != null) {
            head = curr;
            nNext = next!=null ? next.next: null;

            if (next == null)
                break;

            next.next = curr;
            curr = next;
            next = nNext;
        }
        return head;
    }
    ListNode reverseNodePositionByKValues(ListNode head, int K) {

        if (head == null) {
            return head;
        }
        if (K < 1){
            return head;
        }

        ListNode start = head.next, end=null;
        int count = 0;
        ListNode currentNode = head;
        while (currentNode.hasNext()) {
            currentNode = currentNode.next;
            count++;
            end = currentNode;
            if (count == K) {
                reverseNodeStatesFromStartToEnd(start, end, K);
                count = 0;
                end = null;
                start = currentNode.next;
            }
        }
        return head;
    }

    private void reverseNodeStatesFromStartToEnd(ListNode start, ListNode end, int K) {

        int[] tempValues = new int[K];
        int tempIndex = -1;
        ListNode curr = start;
        ListNode prev = null;
        do {
            tempIndex++;
            tempValues[tempIndex] = curr.val;
            prev = curr;
            curr = curr.next;
        } while (prev != end);
        // tempIndex points to last location now
        for (int i=0, j=tempIndex; i<j; i++, j--) {
            int temp = tempValues[i];
            tempValues[i] = tempValues[j];
            tempValues[j] = temp;
        }

        curr = start;
        prev = null;
        int index = 0;
         do {
            curr.val = tempValues[index++];
            prev = curr;
            curr = curr.next;
        } while (prev != end);


    }

    @Override
    public void execute() {

        ListNode head = new ListNode(0);
        int K = 3;

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        head = l1;
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next = null;

        head = reverseLinkedList(head);

//        reverseNodePositionByKValues(head, K);
        ListNode curr = head;
        while(curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }

    }
}
