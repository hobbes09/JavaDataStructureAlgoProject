package com.app.reference;

import com.app.Solution;

import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo implements Solution {

    @Override
    public void execute() {

        // Create a TreeMap (sorted by keys)
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // Basic put() operations
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(5, "Five");
        treeMap.put(4, "Four");

        System.out.println("Initial TreeMap: " + treeMap); // Automatically sorted by keys

        // get() and containsKey()
        System.out.println("Get value for key 3: " + treeMap.get(3));
        System.out.println("Contains key 5? " + treeMap.containsKey(5));

        // firstKey(), lastKey()
        System.out.println("First Key: " + treeMap.firstKey());
        System.out.println("Last Key: " + treeMap.lastKey());

        // floorKey(), ceilingKey(), lowerKey(), higherKey()
        System.out.println("Floor key of 4: " + treeMap.floorKey(4));   // 4
        System.out.println("Ceiling key of 4: " + treeMap.ceilingKey(4)); // 4
        System.out.println("Lower key of 4: " + treeMap.lowerKey(4));   // 3
        System.out.println("Higher key of 4: " + treeMap.higherKey(4)); // 5

        // headMap(), tailMap(), subMap()
        SortedMap<Integer, String> headMap = treeMap.headMap(4); // keys < 4
        SortedMap<Integer, String> tailMap = treeMap.tailMap(3); // keys >= 3
        SortedMap<Integer, String> subMap = treeMap.subMap(2, 5); // 2 <= key < 5

        System.out.println("HeadMap (keys < 4): " + headMap);
        System.out.println("TailMap (keys >= 3): " + tailMap);
        System.out.println("SubMap (2 <= key < 5): " + subMap);

        // pollFirstEntry() and pollLastEntry()
        Map.Entry<Integer, String> firstEntry = treeMap.pollFirstEntry();
        Map.Entry<Integer, String> lastEntry = treeMap.pollLastEntry();
        System.out.println("Polled First Entry: " + firstEntry);
        System.out.println("Polled Last Entry: " + lastEntry);
        System.out.println("TreeMap after polling: " + treeMap);

        // descendingMap()
        NavigableMap<Integer, String> descendingMap = treeMap.descendingMap();
        System.out.println("Descending Map: " + descendingMap);

        // remove()
        treeMap.remove(3);
        System.out.println("After removing key 3: " + treeMap);

        // clear() and isEmpty()
        treeMap.clear();
        System.out.println("Is TreeMap empty after clear()? " + treeMap.isEmpty());

    }
}
