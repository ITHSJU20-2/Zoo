package se.iths.grupp2.zoo.animals.bird;

import se.iths.grupp2.zoo.animals.Animal;
import se.iths.grupp2.zoo.animals.Food;

import java.util.List;

public abstract class Bird extends Animal {

    private boolean canFly;
    private String sound;

    public Bird(String name, List<Food> likes, int xp, boolean canFly, String sound) {
        super(name, likes, xp);
        this.canFly = canFly;
        this.sound = sound;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
