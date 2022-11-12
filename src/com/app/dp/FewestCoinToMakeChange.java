package com.app.dp;

import com.app.Solution;

public class FewestCoinToMakeChange implements Solution {
    @Override
    public void execute() {

        int amount = 15;
        int[] coins = {1,5,6,8};

        int changeCount[][] = new int[coins.length][amount+1];

        for (int iCoin = 0; iCoin < coins.length; iCoin++) {
            for (int tot = 0; tot < amount+1; tot++) {
                if (tot == 0) {
                    changeCount[iCoin][tot] = 0;
                } else if (iCoin == 0) {
                    if (tot % coins[iCoin] == 0)
                        changeCount[iCoin][tot] = tot/coins[iCoin];
                    else
                        changeCount[iCoin][tot] = 0;
                } else {
                    if (coins[iCoin] > tot) {
                        changeCount[iCoin][tot] = changeCount[iCoin-1][tot];
                    } else {
                        changeCount[iCoin][tot] = Math.min(1+changeCount[iCoin][tot-coins[iCoin]], changeCount[iCoin-1][tot]);
                    }
                }
            }
        }

        System.out.println(changeCount[coins.length-1][amount]);

    }
}
