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


    public boolean pet() {
        if (getXp() >= 10) {
            setXp(getXp() + 1);
            return true; //"Clyde is my brother. You may have seen him with Clint Eastwood. So don't get too close.";
        } else
            setXp(getXp() + 2);
        return true; //"Come 'ere you!";
    }


    //different food has different XP??
    public boolean feed(Food Food) {
        if ((Food == se.iths.grupp2.animals.Food.VEGETABLE) || (Food == se.iths.grupp2.animals.Food.FRUIT)) {
            setXp(getXp() + 45);
            setSize(getSize() + 4);
            return true;
        } else if (Food == se.iths.grupp2.animals.Food.BERRY) {
            setXp(getXp() + 15);
            setSize(getSize() + 1);
            return true;
        } else return false;

        /*if (getSize() > 5) {
            return "My arms are a real conversation starter.";

        } else {
            return "I have room for improvement.";
        }*/
    }
}
