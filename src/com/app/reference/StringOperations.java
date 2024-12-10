package com.app.reference;

import com.app.Solution;

public class StringOperations implements Solution {
    @Override
    public void execute() {

        String str = "iamacaveman";
        int len = str.length();

        System.out.println(str.substring(1, len-1));

        //=========================================

        str = "1234";
        System.out.println(Integer.parseInt(str));

    }
}
