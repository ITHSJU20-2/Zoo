package se.iths.grupp2.zoo.animals.canine;


import se.iths.grupp2.zoo.animals.Animal;
import se.iths.grupp2.zoo.animals.Food;

import java.util.List;

public abstract class Canine extends Animal {

    private boolean barking;
    private boolean howling;

    public Canine(String name, List<Food> likes, int xp, boolean barking, boolean howling) {
        super(name, likes, xp);
        this.barking = barking;
        this.howling = howling;
    }

        public boolean isBarking() {
            return barking;
        }

        public boolean isHowling() {
            return howling;
        }
}
