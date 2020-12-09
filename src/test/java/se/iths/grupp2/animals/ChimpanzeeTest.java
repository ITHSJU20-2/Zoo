package se.iths.grupp2.animals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ChimpanzeeTest {

    private Chimpanzee chimpanzee = new Chimpanzee("Chimpanzee", Arrays.asList(Food.MEAT, Food.FRUIT, Food.BERRY),
            0, 0, "Black");

    @Test
    void pet() {
        chimpanzee.pet();
        Assertions.assertEquals(4, chimpanzee.getXp());
    }

    @Test
    void feed() {
        chimpanzee.feed(Food.MEAT);
        Assertions.assertEquals(10, chimpanzee.getXp());
        Assertions.assertEquals(1, chimpanzee.getSize());
    }
}