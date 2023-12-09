package com.aks.stick_hero_ap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getPlayerInstance() { // The singleton design pattern would always return a new object
        Player player = new Player();
        assertEquals(null,player.getPlayerInstance());
    }

    @Test
    void Test2(){
        Player player = new Player(); // The Player has Null set as object type initially
        assertEquals(null,player.getPlayer());
    }
}