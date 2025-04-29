package com.app.reference;

import com.app.Solution;

import java.util.PriorityQueue;
import java.util.Random;

public class HeapDemo implements Solution {

    class Employee {
        public String name;
        public int age;

        public Employee() {
        }

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @Override
    public void execute() {
        int SIZE = 10;
         PriorityQueue<Employee> minHeap = new PriorityQueue<>((e1, e2) -> {
            return e1.age - e2.age;
        });
        PriorityQueue<Employee> maxHeap = new PriorityQueue<>((e1, e2) -> {
            return e2.age - e1.age;
        });

        for(int i=1; i<=SIZE; ++i){
            int data = new Random().nextInt(100) +1; //number between 0 to 100
            minHeap.add(new Employee("name-"+data, data));
            maxHeap.add(new Employee("name-"+data, data));
        }

        System.out.println("Min Heap Content");
        int i = 0;
        while (i++ < SIZE) {
            System.out.println(minHeap.peek());
            System.out.println(minHeap.poll());
        }

        System.out.println("\n Max Heap Content");
        i = 0;
        while (i++ < SIZE) {
            System.out.println(maxHeap.poll());
        }
    }
}
