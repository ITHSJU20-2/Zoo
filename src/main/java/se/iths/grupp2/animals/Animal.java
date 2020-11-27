package se.iths.grupp2.animals;

public class Animal {

    private final String name;
    private final AnimalType animalType;

    public Animal(String name, AnimalType animalType) {
        this.name = name;
        this.animalType = animalType;
    }

    public String getName() {
        return name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }
}
