package se.iths.grupp2.animals.animals;

import java.util.List;

public class Animal {

    private final String name;

    private final List<Food> likes;

    private int xp;

    public Animal(String name, List<Food> likes, int xp) {
        this.name = name;
        this.likes = likes;
        this.xp = xp;
    }

    public String getName() {
        return name;
    }

    public List<Food> getLikes() {
        return likes;
    }

    public int getXp() {
        return xp;
    }

    //Error handling for xp limit
    public void setXp(int xp) {
        if (xp > 5000) {
            setXp(5000);
        } else {
            this.xp = xp;
        }
    }
}
