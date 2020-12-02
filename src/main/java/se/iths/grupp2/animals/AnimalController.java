package se.iths.grupp2.animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnimalController {

    private final List<Animal> animals;

    public AnimalController() {
        this.animals = new ArrayList<>();
        loadAnimals();
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void loadAnimals() {
        // Create all the animals in here and add to the list
        Animal gorilla = new Gorilla("Gorilla", Collections.singletonList(Food.FRUIT),0,0,"Silver");
        Animal chimpanzee = new Chimpanzee("Chimpanzee",Collections.singletonList(Food.FRUIT),0,0,"Black");
        Animal orangutan = new Orangutan("Orangutan",Collections.singletonList(Food.FRUIT),0,0,"Orange");
        animals.addAll(Arrays.asList(gorilla,chimpanzee,orangutan));
    }

    public void feed(Animal animal, Food food) {
        if (animal.getLikes().contains(food)) {
            animal.setXp(animal.getXp() + 4);
        }
    }

    public void pet(Animal animal) {
        animal.setXp(animal.getXp() + 1);
    }

}
