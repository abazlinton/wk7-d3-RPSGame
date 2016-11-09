package com.example.user.rpsgame;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


/**
 * Created by user on 09/11/2016.
 */

public class GameLogicTest {

    GameLogic gameLogicRock;
    GameLogic gameLogicPaper;
    GameLogic gameLogicScissors;
    protected String[] mPlays = {"rock", "paper", "scissors"};

    @Before
    public void before() {
        gameLogicPaper = new GameLogic("paper");
    }

    @Test
    public void testGetComputerPlayReturnsString() {
        assertTrue(gameLogicPaper.getComputerPlay() instanceof String);
    }

    @Test
    public void testGetComputerPlayReturnsGoodString() {
        assertTrue(Arrays.asList(mPlays).contains(gameLogicPaper.getComputerPlay()));
    }


}