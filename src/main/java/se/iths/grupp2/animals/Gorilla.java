package se.iths.grupp2.animals;

import java.util.List;

public class Gorilla extends Ape {
    private static String liked;
    private static String tolerated;

    public Gorilla(String name, List likes, int xp, int size, String colour) {
        super(name, likes, xp, size, colour);
        liked = "That's what I'm talkin' about...";
        tolerated = "That'll do for now. But if more is not forthcoming, I shall have at you, sir.";
    }


    public String pet() {
        if (getXp() > 10) {
            return "Dude, really? Petting me? The mighty " + getName() + "? You got a death wish?!";
        } else
            setXp(getXp() + 1);
        return "Thank you!";
    }

    //different food has different XP??
    public String feed(Food Food) {
        if ((Food == se.iths.grupp2.animals.Food.MEAT) || (Food == se.iths.grupp2.animals.Food.FRUIT)) {
            setXp(getXp() + 50);
            setSize(getSize() + 5);
            return liked;
        } else if (Food == se.iths.grupp2.animals.Food.BERRY) {
            setXp(getXp() + 20);
            setSize(getSize() + 2);
            return tolerated;
        }
        if (getSize() > 5) {
            return "I am the strongest of all apes. Admire my mighty growth.";

        } else {
            return "I'm still puny. And I blame you.";
        }
    }
}
