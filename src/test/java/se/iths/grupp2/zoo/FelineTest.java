package se.iths.grupp2.zoo;

import org.junit.jupiter.api.Test;
import se.iths.grupp2.zoo.animals.Food;
import se.iths.grupp2.zoo.animals.feline.Cat;
import se.iths.grupp2.zoo.animals.feline.Lion;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineTest {

    private final se.iths.grupp2.zoo.animals.feline.Lion Lion = new Lion("Lion", Arrays.asList(Food.MEAT), 0, true, "ROooar");
    private final se.iths.grupp2.zoo.animals.feline.Cat Cat = new Cat("Cat", Arrays.asList(Food.MEAT), 0, false, "Mjauu");

    @Test
    void isWild() {
        assertEquals(true, Lion.isWild());
        assertEquals(false, Cat.isWild());
    }

    @Test
    void getSound() {
        assertEquals("ROooar", Lion.getSound());
        assertEquals("Mjauu", Cat.getSound());
    }

    @Test
    void feedCat() {
        Main.getController().feed(Cat,Food.MEAT);
        assertEquals(4, Cat.getXp());
    }

    @Test
    void feedLion() {
        Main.getController().feed(Lion,Food.MEAT);
        assertEquals(4,Lion.getXp());
    }
}