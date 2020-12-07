package se.iths.grupp2.animals;

import java.util.ArrayList;
import java.util.List;

public class AnimalController {

    private List<Animal> animals;

    public AnimalController() {
        this.animals = new ArrayList<>();
    }

    /**
     * Getter for AnimalController#animals
     *
     * @return The animal list
     */
    public List<Animal> getAnimals() {
        return animals;
    }

    /**
     * Checks if the animal likes the food, if it does. Feed it and reward it 4 experience points.
     *
     * @param animal The animal to feed.
     * @param food   The food to feed the animal.
     * @return A boolean of whether the animal was fed due to it's food preferences.
     */
    public boolean feed(Animal animal, Food food) {
        if (animal.getLikes().contains(food)) {
            animal.setXp(animal.getXp() + 4);
            return true;
        }
        return false;
    }

    /**
     * Pets the animal and rewards it 1 experience point.
     *
     * @param animal The animal to pet.
     */
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

    /**
     * Setter for AnimalController#animals
     *
     * @param animals The list to set the animal list to.
     */
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
