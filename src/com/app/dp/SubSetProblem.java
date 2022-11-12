package com.app.dp;

import com.app.Solution;

public class SubSetProblem implements Solution {
    @Override
    public void execute() {

        int total = 11;
        int[] arr = {2,3,7,8,10};
        boolean res = false;

        boolean ss[][] = new boolean[arr.length+1][total+1];

        for (int idx=0; idx<=arr.length; idx++) {
            for (int tot=0; tot<=total; tot++) {
                if(idx==0 || tot==0) {
                    ss[idx][tot] = false;
                } else {
                    if (tot-arr[idx-1] == 0) {
                        ss[idx][tot] = true;
                    } else if (tot-arr[idx-1] > 0) {
                        ss[idx][tot] = ss[idx-1][tot] || ss[idx][tot-arr[idx-1]];
                    } else {
                        ss[idx][tot] = ss[idx-1][tot];
                    }
                }
                System.out.print(ss[idx][tot] + " ");
                if (tot == total && ss[idx][tot] && !res) {
                    res = true;
                }
            }
            System.out.println("\n");
        }

        System.out.println(res);
    }
}
