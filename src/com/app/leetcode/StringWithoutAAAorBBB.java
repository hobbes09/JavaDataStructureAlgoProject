package com.app.leetcode;

import com.app.Solution;

public class StringWithoutAAAorBBB implements Solution {
    @Override
    public void execute() {

        int a = 6, b = 2;
        char aChar = 'a';
        char bChar = 'b';
        char smallerChar = 'b';

        if (b > a){
            int tmp = a;
            a = b;
            b = tmp;

            char tmpCh = aChar;
            aChar = bChar;
            bChar = tmpCh;

            smallerChar = 'a';
        }


        StringBuilder out = new StringBuilder(a+b);

        while (a > 0 || b > 0) {
            if (a - b >= 2) {
                out.append(aChar);
                a--;
            } else {
                char lastChar = smallerChar;
                if (out.length() > 0)
                    lastChar = out.charAt(out.length() - 1);
                if (lastChar == aChar) {
                    if (b > 0) {
                        out.append(bChar);
                        b--;
                    }
                    else {
                        out.append(aChar);
                        a--;
                    }
                } else {
                    if (a > 0) {
                        out.append(aChar);
                        a--;
                    }
                    else {
                        out.append(bChar);
                        b--;
                    }
                }
            }
        }
        System.out.println(out.toString());
    }
}
