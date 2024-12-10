package com.app.leetcode;

import com.app.Solution;
import java.util.*;

/**
 As a part of underwriting, we get user data. Part of the data is the user medical history
 One element of medical history is their prescription history, which is a list of prescriptions.
 A prescription has a drug_name, a start and an end. Given a prescription history, we are interested in knowing the maximum number of concurrent medication they we prescribed.


 Input:
 (A, 1, 5)
 (B, 6, 10)
 (C, 3, 8)

 Output: 2


 (A, 1, 5)  - 1 (A)
 (C, 3, 8)  - 2 (A, C)
 (B, 6, 10)  - 2 (C, B)


 (A, 1), (C,3), (-A, 5) , (B, 6), (-C,8), (-B, 10)

 +1+1-1+1-1-1
 max(prefixSum) = maxConcurrency


 */


class MedicalHistory implements Solution {

    class MedEndEntry {
        String medname;
        int endTime;
        public MedEndEntry(String medname, int endTime) {
            this.medname = medname;
            this.endTime = endTime;
        }
    }

    PriorityQueue<MedEndEntry> minHeapMedEndEntries;
    int concurrent = 0;

    public int getMaxConcurrentMeds(String[][] history){

        if(history.length == 0)
            return 0;

        minHeapMedEndEntries = new PriorityQueue<MedEndEntry>((m1, m2)->{
            return m1.endTime - m2.endTime;
        });

        Arrays.sort(history, new Comparator<String[]>() {
            @Override
            public int compare(String[] h1, String[] h2) {
                int startTime1 = Integer.parseInt(h1[1]);
                int startTime2 = Integer.parseInt(h2[1]);
                return startTime1-startTime2;
            }
        });

        for (String[] entry: history) {
            removeElementsOlderThan(Integer.parseInt(entry[1]));
            int concurrentAtThisStep = addNewMedication(entry[0], Integer.parseInt(entry[2]));
            concurrent = (concurrentAtThisStep > concurrent)? concurrentAtThisStep: concurrent;
        }

        return concurrent;
    }

    public void removeElementsOlderThan(int startTime) {

        while (!minHeapMedEndEntries.isEmpty()) {

            MedEndEntry recentEnd = minHeapMedEndEntries.peek();
            if (recentEnd.endTime >= startTime) {
                return;
            }
            minHeapMedEndEntries.poll();
        }
    }

    public int addNewMedication(String medName, int endTime) {
        minHeapMedEndEntries.add(new MedEndEntry(medName, endTime));
        return minHeapMedEndEntries.size();
    }

    @Override
    public void execute() {
        String[][] history = new String[][]{{"A", "1", "5"},  {"B", "4", "10"}, {"C", "3", "8"}};
        MedicalHistory mHistory = new MedicalHistory();
        System.out.println(mHistory.getMaxConcurrentMeds(history));
    }

}