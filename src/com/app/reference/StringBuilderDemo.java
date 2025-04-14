package com.app.reference;

import com.app.Solution;

public class StringBuilderDemo implements Solution {

    @Override
    public void execute() {

        // 1. Create a new StringBuilder
        StringBuilder sb = new StringBuilder("Hello");

        // 2. Append text
        sb.append(" World");
        System.out.println("After append: " + sb);  // Hello World

        // 3. Insert text at a specific index
        sb.insert(6, "Beautiful ");
        System.out.println("After insert: " + sb);  // Hello Beautiful World

        // 4. Replace a portion of the string
        sb.replace(6, 15, "Amazing");
        System.out.println("After replace: " + sb);  // Hello Amazing World

        // 5. Delete a portion of the string
        sb.delete(5, 13);
        System.out.println("After delete: " + sb);  // Hello World

        // 6. Reverse the string
        sb.reverse();
        System.out.println("After reverse: " + sb);  // dlroW olleH

        // 7. Convert back to String
        String finalString = sb.toString();
        System.out.println("Final String: " + finalString);  // dlroW olleH

        // 8. Get capacity and length
        System.out.println("Capacity: " + sb.capacity());
        System.out.println("Length: " + sb.length());

        // 9. Extract a substring (e.g., characters from index 3 to 8)
        String extracted = sb.substring(3, 8);
        System.out.println("Extracted substring (3 to 8): " + extracted);  // roW o

    }
}
