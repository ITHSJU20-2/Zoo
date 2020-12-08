package se.iths.grupp2.animals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GorillaTest {

    private Gorilla gorilla = new Gorilla("Gorilla", Arrays.asList(Food.MEAT, Food.FRUIT, Food.BERRY), 0, 0,
            "Silver and black");

    @Test
    void pet() {
        gorilla.pet();
        Assertions.assertEquals(1, gorilla.getXp());
    }

    @Test
    void feed() {
        gorilla.feed(Food.MEAT);
        Assertions.assertEquals(50, gorilla.getXp());
        Assertions.assertEquals(5, gorilla.getSize());
    }
}