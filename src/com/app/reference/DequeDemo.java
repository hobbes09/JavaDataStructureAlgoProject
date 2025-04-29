package com.app.reference;

import com.app.Solution;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo implements Solution {

    @Override
    public void execute() {

        Deque<Integer> deque = new LinkedList<>();

        // Using Deque as a Stack (LIFO)
        System.out.println("== Using Deque as Stack ==");
        deque.push(10); // same as addFirst()
        deque.push(20);
        deque.push(30);

        System.out.println("Stack after pushes: " + deque); // [30, 20, 10]
        System.out.println("Top element: " + deque.peek()); // 30
        System.out.println("Popped: " + deque.pop());       // 30
        System.out.println("Stack after pop: " + deque);    // [20, 10]

        // Clear the deque before using it as a queue
        deque.clear();

        // Using Deque as a Queue (FIFO)
        System.out.println("\n== Using Deque as Queue ==");
        deque.offer(10); // same as addLast()
        deque.offer(20);
        deque.offer(30);

        System.out.println("Queue after offers: " + deque); // [10, 20, 30]
        System.out.println("Front element: " + deque.peek()); // 10
        System.out.println("Polled: " + deque.poll());        // 10
        System.out.println("Queue after poll: " + deque);     // [20, 30]

    }
}
