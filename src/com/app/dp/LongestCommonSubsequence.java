package com.app.dp;

import com.app.Solution;

/*
https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
https://www.youtube.com/watch?v=ASoaQq66foQ
 */
public class LongestCommonSubsequence implements Solution {
    @Override
    public void execute() {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X= s1.toCharArray();
        char[] Y= s2.toCharArray();
        int lenX = X.length;
        int lenY = Y.length;

        System.out.println(recursiveLcs(X, Y, lenX, lenY));

        System.out.println(optimisedLcs(X, Y, lenX, lenY));

    }

    private int optimisedLcs(char[] x, char[] y, int lenX, int lenY) {

        int[][] lcs = new int[lenX+1][lenY+1];

        for (int ix = 0; ix < lenX+1; ix++) {
            for (int iy=0; iy < lenY+1; iy++) {
                if (ix == 0 || iy == 0) {
                    lcs[ix][iy] = 0;
                } else {
                    if (x[ix-1] == y[iy-1]) {
                        lcs[ix][iy] = 1 + lcs[ix-1][iy-1];
                    } else {
                        lcs[ix][iy] = Math.max(lcs[ix-1][iy], lcs[ix][iy-1]);
                    }
                }
            }
        }
        return lcs[lenX][lenY];
    }

    private int recursiveLcs(char[] x, char[] y, int lenX, int lenY) {

        if (lenX == 0 || lenY == 0) {
            return 0;
        } else {
            if (x[lenX - 1] == y[lenY - 1]) {
                return 1 + recursiveLcs(x, y, lenX-1, lenY-1);
            } else {
                return Math.max(recursiveLcs(x, y, lenX-1, lenY), recursiveLcs(x, y, lenX, lenY-1));
            }
        }
    }
}
