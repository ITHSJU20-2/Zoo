package se.iths.grupp2.animals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BirdTests {

    private final Eagle eagle = new Eagle("Eagle", Collections.singletonList(Food.FRUIT), 0, true, "Skreaaaaagh");
    private final Ostrich ostrich = new Ostrich("Ostrich", Arrays.asList(Food.BERRY, Food.FRUIT), 0, false, "???");
    private final Pigeon pigeon = new Pigeon("Pigeon", Collections.singletonList(Food.VEGETABLE), 0, true, "kurrkurr");

    @Test
    public void feedEagle() {
        Main.getController().feed(eagle, Food.FRUIT);
        assertEquals(4, eagle.getXp());
    }

    @Test
    public void feedOstrich() {
        Main.getController().feed(ostrich, Food.VEGETABLE);
        Main.getController().feed(ostrich, Food.FRUIT);
        assertEquals(4, ostrich.getXp());
    }

    @Test
    public void feedPigeon() {
        Main.getController().feed(pigeon, Food.MEAT);
        assertEquals(0, pigeon.getXp());
    }

    @Test
    void petEagle() {
        Main.getController().pet(eagle);
        Main.getController().pet(eagle);
        Main.getController().pet(eagle);
        Main.getController().pet(eagle);
        Main.getController().pet(eagle);
        assertEquals(5, eagle.getXp());
    }

    @Test
    void petOstrich() {
        Main.getController().pet(ostrich);
        assertEquals(1, ostrich.getXp());
    }

    @Test
    void petPigeon() {
        Main.getController().pet(pigeon);
        assertEquals(1, pigeon.getXp());
    }

    @AfterEach
    void tearDown() {
        eagle.setXp(0);
        ostrich.setXp(0);
        pigeon.setXp(0);
    }
}