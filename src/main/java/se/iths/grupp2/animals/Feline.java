package se.iths.grupp2.animals;
import java.util.List;

public abstract class Feline extends Animal {

    private String sound;
    private boolean wild;

    public Feline(String name, List<Food> dislikes, List<Food> likes, int xp, boolean wild, String sound) {
        super(name, dislikes, likes, xp);
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
