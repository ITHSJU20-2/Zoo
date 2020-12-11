package se.iths.grupp2.animals;

import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SeaCreatureTest {
    private final Animal Goldfish = new Goldfish ("Goldfish", Arrays.asList(Food.BERRY), 0, false, "Small teeth", "Small fins", true);
    private final Animal Shark = new Shark ("Shark", Arrays.asList(Food.MEAT), 0, true, "Lots of big teeth", "Delicious fins", "chews a lot");

    @BeforeAll
    public void startOfSeaCreaturesTest (){
        System.out.println("Will run before every test");

    }
}