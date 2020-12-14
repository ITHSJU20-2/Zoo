package se.iths.grupp2.zoo.animals.canine;

import se.iths.grupp2.zoo.animals.Food;

import java.util.List;

public class Dog extends Canine {
    public Dog(String name, List<Food> likes, int xp, boolean barking, boolean howling) {
        super(name, likes, xp, barking, howling);
    }
}