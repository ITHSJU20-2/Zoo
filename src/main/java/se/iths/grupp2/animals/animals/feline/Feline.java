package se.iths.grupp2.animals.animals.feline;

import se.iths.grupp2.animals.animals.Animal;
import se.iths.grupp2.animals.animals.Food;

import java.util.List;

public abstract class Feline extends Animal {

    private String sound;
    private boolean wild;

    public Feline(String name, List<Food> likes, int xp, boolean wild, String sound) {
        super(name, likes, xp);
        this.sound = sound;
        this.wild = wild;
    }

    public boolean isWild() {
        return wild;
    }

    public String getSound() {
        return sound;
    }
}
