
package com.example.user.rpsgame;

import java.util.Random;

public class GameLogic {

    String userPlay;
    String computerPlay;
    String[] returnResult = {"", ""};
    protected String[] mPlays = {"rock", "paper", "scissors"};
    protected String[][] mPairs = {
            {"paper", "rock"},
            {"rock", "scissors"},
            {"scissors", "paper"}
    };

    public GameLogic(String userPlay) {
        this.userPlay = userPlay;
        getResult();
    }

    public String getComputerPlay() {
        int randomIndex = getRandomInt(0, 2);
        String computerPlay = mPlays[randomIndex];
        return computerPlay;
    }

    public int getRandomInt(int min, int max) {
        Random random = new Random();
        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public String[] getResult() {
        computerPlay = getComputerPlay();
        returnResult[0] = computerPlay;

        if (userPlay == computerPlay) {
            returnResult[1] = "Draw";
        }
        else if (
                userPlay == mPairs[0][0] && computerPlay == mPairs[0][1] ||
                        userPlay == mPairs[1][0] && computerPlay == mPairs[1][1] ||
                        userPlay == mPairs[2][0] && computerPlay == mPairs[2][1]
                ) {
            returnResult[1] = "Player wins";
        }

        else {
            returnResult[1] = "Trump wins \n"
                    + "(... and everybody else loses)";
        }
        return returnResult;
    }

}