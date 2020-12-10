package se.iths.grupp2.animals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CanineTest {

    private final Wolf Wolf = new Wolf("Wolf", Arrays.asList(Food.MEAT), 0, false, true);
    private final Coyote Coyote = new Coyote("Coyote", Arrays.asList(Food.MEAT), 0, true, false);
    private final Dog Dog = new Dog("Dog", Arrays.asList(Food.MEAT), 0, true, true);

    @Test
    void isHowling() {
        assertEquals(true, Wolf.isHowling());
        assertEquals(false, Coyote.isHowling());
        assertEquals(true, Dog.isHowling());
    }

    @Test
    void isBarking() {
        assertEquals(false, Wolf.isBarking());
        assertEquals(true, Coyote.isBarking());
        assertEquals(true, Dog.isBarking());
    }

    @Test
    void feedWolf() {
        Main.getController().feed(Wolf,Food.MEAT);
        assertEquals(4, Wolf.getXp());
    }

    @Test
    void feedCoyote() {
        Main.getController().feed(Coyote,Food.MEAT);
        assertEquals(4, Coyote.getXp());
    }
    @Test
    void feedDog() {
        Main.getController().feed(Dog,Food.MEAT);
        assertEquals(4,Dog.getXp());
    }
}