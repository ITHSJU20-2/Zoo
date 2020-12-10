package se.iths.grupp2.animals;

import java.util.List;

public class Orangutan extends Ape {

    public Orangutan(String name, List likes, int xp, int size, String colour) {
        super(name, likes, xp, size, colour);
    }


    public boolean pet() {
        if (getXp() >= 10) {
            setXp(getXp() + 1);
            return true;
        } else
            setXp(getXp() + 2);
        return true;
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
    }
}
