package se.iths.grupp2.animals;

import org.junit.jupiter.api.*;

import java.util.Arrays;

class ApeTests {

    private Gorilla gorilla = new Gorilla("Gorilla", Arrays.asList(Food.MEAT, Food.FRUIT, Food.BERRY), 0, 0,
            "Silver and black");
    private Orangutan orangutan = new Orangutan("Orangutan", Arrays.asList(Food.VEGETABLE, Food.FRUIT, Food.BERRY),
            0, 0, "Orange");
    private Chimpanzee chimpanzee = new Chimpanzee("Chimpanzee", Arrays.asList(Food.MEAT, Food.FRUIT, Food.BERRY),
            0, 0, "Black");

    @BeforeAll
    static void apeTestStart() {
        System.out.println("Begin ape testing");
    }

    @AfterEach
    void resetApe() {
        gorilla.setXp(0);
        orangutan.setXp(0);
        chimpanzee.setXp(0);
    }

    @AfterAll
    static void apeTestsComplete() {
        System.out.println("All apes tested");
    }

    //TESTS OF METHODS IN CONTROLLER CLASS
    @Test
    void petGorilla() {
        Main.getController().pet(gorilla);
        Assertions.assertEquals(1, gorilla.getXp());
    }

    @Test
    void feedGorilla() {
        Main.getController().feed(gorilla, Food.MEAT);
        Main.getController().feed(gorilla, Food.BERRY);
        Main.getController().feed(gorilla, Food.VEGETABLE);
        Main.getController().feed(gorilla, Food.FRUIT);
        Assertions.assertEquals(12, gorilla.getXp());
    }

    @Test
    void petOrangutan() {
        Main.getController().pet(orangutan);
        Main.getController().pet(orangutan);
        Assertions.assertEquals(2, orangutan.getXp());
    }

    @Test
    void feedOrangutan() {
        Main.getController().feed(orangutan, Food.MEAT);
        Assertions.assertEquals(0, orangutan.getXp());
    }

    @Test
    void petChimpanzee() {
        Main.getController().pet(chimpanzee);
        Main.getController().pet(chimpanzee);
        Main.getController().pet(chimpanzee);
        Assertions.assertEquals(3, chimpanzee.getXp());
    }

    @Test
    void feedChimpanzee() {
        Main.getController().feed(chimpanzee, Food.BERRY);
        Main.getController().feed(chimpanzee, Food.BERRY);
        Assertions.assertEquals(8, chimpanzee.getXp());
    }

    //TESTS OF METHODS IN INDIVIDUAL APE CLASSES- UNCLEAR (PERHAPS UNLIKELY?) IF THESE WILL BE USED
    @Test
    void petGorillaClass() {
        gorilla.pet();
        Assertions.assertEquals(1, gorilla.getXp());
    }

    @Test
    void feedGorillaClass() {
        gorilla.feed(Food.MEAT);
        Assertions.assertEquals(50, gorilla.getXp());
        Assertions.assertEquals(5, gorilla.getSize());
    }

    @Test
    void petOrangutanClass() {
        orangutan.pet();
        Assertions.assertEquals(2, orangutan.getXp());
    }

    @Test
    void feedOrangutanClass() {
        orangutan.feed(Food.VEGETABLE);
        Assertions.assertEquals(45, orangutan.getXp());
        Assertions.assertEquals(4, orangutan.getSize());
    }

    @Test
    void petChimpanzeeClass() {
        chimpanzee.pet();
        Assertions.assertEquals(4, chimpanzee.getXp());
    }

    @Test
    void feedChimpanzeeClass() {
        chimpanzee.feed(Food.MEAT);
        Assertions.assertEquals(10, chimpanzee.getXp());
        Assertions.assertEquals(1, chimpanzee.getSize());
    }
}