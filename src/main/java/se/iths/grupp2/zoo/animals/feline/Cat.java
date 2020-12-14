package se.iths.grupp2.zoo.animals.feline;

import se.iths.grupp2.zoo.animals.Food;

import java.util.List;

public class Cat extends Feline {
    public Cat(String name, List<Food> likes, int xp, boolean wild, String sound) {
        super(name, likes, xp, wild, sound);
    }
}
