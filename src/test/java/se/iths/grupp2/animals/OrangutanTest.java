package se.iths.grupp2.animals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class OrangutanTest {

    private Orangutan orangutan = new Orangutan("Orangutan", Arrays.asList(Food.VEGETABLE, Food.FRUIT, Food.BERRY),
            0, 0, "Orange");

    @Test
    void pet() {
        orangutan.pet();
        Assertions.assertEquals(2, orangutan.getXp());
    }

    @Test
    void feed() {
        orangutan.feed(Food.VEGETABLE);
        Assertions.assertEquals(45, orangutan.getXp());
        Assertions.assertEquals(4, orangutan.getSize());
    }
}