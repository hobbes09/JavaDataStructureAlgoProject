package com.app.leetcode;

import com.app.Solution;

import java.util.*;

/**
 * You are driving a vehicle that has capacity empty seats initially available for passengers.
 * The vehicle only drives east (ie. it cannot turn around and drive west.)
 * Given a list of trips, trip[i] = [num_passengers, start_location, end_location]
 * contains information about the i-th trip: the number of passengers that must be picked up,
 * and the locations to pick them up and drop them off.
 * The locations are given as the number of kilometers due east from your vehicle's initial location.
 *
 * Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
 */

public class CarPooling implements Solution {

    public boolean carPooling(int[][] trips, int capacity) {

        List<int[]> tripsAll = Arrays.asList(trips);
        Collections.sort(tripsAll, (a,b)-> {
            if(a[1] == b[1]) {
                return 0;
            } else if (a[1] < b[1]) {
                return -1;
            } else {
                return 1;
            }
        });

        HashMap<Integer, Integer> stops = new HashMap<>();
        for (int i = 0; i < tripsAll.size(); i++) {
            //System.out.println(tripsAll.get(i)[1] + " " + tripsAll.get(i) [2]);



        }



        return false;
    }

    @Override
    public void execute() {
        int arr[][] = {{3,2,7},{3,7,9},{8,3,9}};
        carPooling(arr, 4);
    }
}
