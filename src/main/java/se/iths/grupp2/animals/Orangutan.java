package se.iths.grupp2.animals;

import java.util.List;

public class Orangutan extends Ape {
    private static String liked;
    private static String tolerated;

    public Orangutan(String name, List likes, int xp, int size, String colour) {
        super(name, likes, xp, size, colour);
        liked = "Not bad, dude.";
        tolerated = "I prefer tacos, but this'll do.";
    }


    public String pet() {
        if (getXp() > 10) {
            return "Clyde is my brother. You may have seen him with Clint Eastwood. So don't get too close.";
        } else return "Come 'ere you!";
    }


    //different food has different XP??
    public String feed() {
        if (getLikes().contains(Food.FRUIT) || getLikes().contains(Food.VEGETABLE)) {
            setXp(getXp() + 50);
            setSize(getSize() + 5);
            return liked;
        } else if (getLikes().contains(Food.BERRY)) {
            setXp(getXp() + 20);
            setSize(getSize() + 2);
            return tolerated;
        }
        if (getXp() > 50) {
            return "My arms are a real conversation starter.";

        } else {
            return "I have room for improvement.";
        }
    }
}
