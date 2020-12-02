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
        Animal pigeon = new Pigeon("Pigeon", Arrays.asList(Food.BERRY, Food.VEGETABLE), 0, true, "kurrkurr");
        Animal eagle = new Eagle("Eagle", Collections.singletonList(Food.VEGETABLE), 0, true, "skreaaaaagh");
        Animal ostrich = new Ostrich("Ostrich", Collections.singletonList(Food.FRUIT), 0, false, "???");

        // Add all the animals to the list
        animals.addAll(Arrays.asList(pigeon, eagle, ostrich));
    }

    public boolean feed(Animal animal, Food food) {
        if (animal.getLikes().contains(food)) {
            animal.setXp(animal.getXp() + 4);
            return true;
        }
        return false;
    }

    public void pet(Animal animal) {
        animal.setXp(animal.getXp() + 1);
    }

    public Animal getAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

}
