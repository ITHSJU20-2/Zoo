package se.iths.grupp2.animals;

import java.util.List;

public class Chimpanzee extends Ape {

    public Chimpanzee(String name, List likes, int xp, int size, String colour) {
        super(name, likes, xp, size, colour);
    }


    public boolean pet() {
        if (getXp() >= 10) {
            setXp(getXp() + 2);
            return true;
        } else
            setXp(getXp() + 4);
        return true;
    }


    public boolean feed(Food Food) {
        if ((Food == se.iths.grupp2.animals.Food.FRUIT) || (Food == se.iths.grupp2.animals.Food.BERRY)) {
            setXp(getXp() + 40);
            setSize(getSize() + 2);
            return true;
        } else if (Food == se.iths.grupp2.animals.Food.MEAT) {
            setXp(getXp() + 10);
            setSize(getSize() + 1);
            return true;
        } else return false;
    }
}
