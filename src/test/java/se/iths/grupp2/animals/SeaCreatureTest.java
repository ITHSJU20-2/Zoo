package se.iths.grupp2.animals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SeaCreatureTest {
    private final Animal Goldfish = new Goldfish ("Goldfish", Arrays.asList(Food.BERRY), 0, false, "Small teeth", "Small fins", true);
    private final Animal Shark = new Shark ("Shark", Arrays.asList(Food.MEAT), 0, true, "Lots of big teeth", "Delicious fins", "chews a lot");

    @BeforeAll
    static void startOfSeaCreaturesTest (){
        System.out.println("Will run before any other test");

    }

    @AfterAll
    static void endOfTest (){
        System.out.println("All seacreatures has been tested");
    }

    @AfterEach
    public void resetXP (){
        Shark.setXp(0);
        Goldfish.setXp(0);
    }

    @Test
    public void feedShark (){
        Main.getController().feed(Shark, Food.BERRY);
        assertEquals(0,Shark.getXp());
    }

    @Test
    public void petShark (){
        Main.getController().pet(Shark);
        assertNotEquals(2,Shark.getXp() );
    }

    @Test
    public void feedGoldFish (){
        Main.getController().feed(Goldfish, Food.BERRY);
        assertEquals(2,2);
    }

    @Test
    public void petGoldFish (){
        Main.getController().pet(Goldfish);
        assertNotEquals(100,2);
    }
}