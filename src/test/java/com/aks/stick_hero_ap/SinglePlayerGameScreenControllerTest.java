package com.aks.stick_hero_ap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglePlayerGameScreenControllerTest {

    @Test
    void getPlayerInstance() { // The singleton design pattern would always return a new object thus false
        SinglePlayerGameScreenController singlePlayerGameScreenController = new SinglePlayerGameScreenController();
        assertEquals(null,singlePlayerGameScreenController.getPlayerInstance());
    }

    @Test
    void Test2(){ // The object is initially a null object thus test would return true
        SinglePlayerGameScreenController singlePlayerGameScreenController = new SinglePlayerGameScreenController();
        assertEquals(null,singlePlayerGameScreenController.getPlayer());
    }
}