package se.iths.grupp2.animals.animals.ape;

import se.iths.grupp2.animals.animals.Food;

import java.util.List;

public class Gorilla extends Ape {

    public Gorilla(String name, List likes, int xp, int size, String colour) {
        super(name, likes, xp, size, colour);
    }


    public boolean pet() {
        if (getXp() >= 10) {
            return false;
        } else
            setXp(getXp() + 1);
        return true;
    }

    //different food has different XP??
    public boolean feed(Food Food) {
        if ((Food == se.iths.grupp2.animals.animals.Food.MEAT) || (Food == se.iths.grupp2.animals.animals.Food.FRUIT)) {
            setXp(getXp() + 50);
            setSize(getSize() + 5);
            return true;
        } else if (Food == se.iths.grupp2.animals.animals.Food.BERRY) {
            setXp(getXp() + 20);
            setSize(getSize() + 2);
            return true;
        } else return false;
    }
}
