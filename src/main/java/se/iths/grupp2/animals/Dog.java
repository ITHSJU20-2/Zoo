package se.iths.grupp2.animals;

import java.util.List;

public class Dog extends Canine{
    public Dog (String name, List<Food> dislikes, List<Food> likes, int xp, boolean barking) {
            super(name, dislikes, likes, xp, barking);
    }
}