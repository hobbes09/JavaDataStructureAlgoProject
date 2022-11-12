package com.app.dp;

import com.app.Solution;

/*
https://www.youtube.com/watch?v=BysNXJHzCEs
 */
public class LongestCommonSubstring implements Solution {

    @Override
    public void execute() {
        String s1 = "AGGTAB";
        String s2 = "GXGTAYB";

        char[] X= s1.toCharArray();
        char[] Y= s2.toCharArray();
        int lenX = X.length;
        int lenY = Y.length;

        System.out.println(optimisedLcs(X, Y, lenX, lenY));
    }

    private int optimisedLcs(char[] x, char[] y, int lenX, int lenY) {

        int[][] lcs = new int[lenX+1][lenY+1];
        int max = 0;

        for (int ix = 0; ix < lenX+1; ix++) {
            for (int iy=0; iy < lenY+1; iy++) {
                if (ix == 0 || iy == 0) {
                    lcs[ix][iy] = 0;
                } else {
                    if (x[ix-1] == y[iy-1]) {
                        lcs[ix][iy] = 1 + lcs[ix-1][iy-1];
                    } else {
                        lcs[ix][iy] = 0;
                    }
                }
                max = lcs[ix][iy] > max ? lcs[ix][iy]:max;
            }
        }
        return max;
    }


}
