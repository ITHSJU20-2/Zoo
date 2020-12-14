package se.iths.grupp2.zoo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import se.iths.grupp2.zoo.animals.Food;
import se.iths.grupp2.zoo.animals.seacreatures.Goldfish;
import se.iths.grupp2.zoo.animals.seacreatures.Shark;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SeaCreatureTest {
    private final Goldfish goldfish = new Goldfish("Goldfish", Arrays.asList(Food.BERRY), 0, false, "Small teeth",
            "Small fins", true);
    private final Shark shark = new Shark("Shark", Arrays.asList(Food.MEAT), 0, true, "Lots of big teeth", "Delicious" +
            " fins", "chews a lot");

    @BeforeAll
    static void startOfSeaCreaturesTest() {
        System.out.println("Will run before any other test");

    }

    @AfterAll
    static void endOfTest() {
        System.out.println("All seacreatures has been tested");
    }

    @AfterEach
    public void resetXP () {
        shark.setXp(0);
        goldfish.setXp(0);
    }

    @Test
    public void feedShark () {
        Main.getController().feed(shark, Food.BERRY);
        assertEquals(0, shark.getXp());
    }

    @Test
    public void petShark () {
        Main.getController().pet(shark);
        assertNotEquals(2, shark.getXp());
    }

    @Test
    public void feedGoldFish () {
        Main.getController().feed(goldfish, Food.BERRY);
        assertEquals(4, goldfish.getXp());
    }

    @Test
    public void petGoldFish () {
        Main.getController().pet(goldfish);
        assertNotEquals(100, goldfish.getXp());
    }
}