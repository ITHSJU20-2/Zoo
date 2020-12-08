package se.iths.grupp2.animals;

import java.util.List;

public class Chimpanzee extends Ape {
    private static String liked;
    private static String tolerated;

    public Chimpanzee(String name, List likes, int xp, int size, String colour) {
        super(name, likes, xp, size, colour);
        liked = "Yes. Good! Feed my growing brain.";
        tolerated = "Is this the best you got?.";
    }


    public String pet() {
        if (getXp() > 10) {
            setXp(getXp() + 2);
            return "If I felt like it, I could destroy you. Go watch Planet of the Apes.";
        } else
            setXp(getXp() + 4);
        return "I like you, haven't felt this loved since I met Michael Jackson!";
    }


    public String feed(Food Food) {
        if ((Food == se.iths.grupp2.animals.Food.FRUIT) || (Food == se.iths.grupp2.animals.Food.BERRY)) {
            setXp(getXp() + 40);
            setSize(getSize() + 2);
            return liked;
        } else if (Food == se.iths.grupp2.animals.Food.MEAT) {
            setXp(getXp() + 10);
            setSize(getSize() + 1);
            return tolerated;
        }
        if (getSize() > 5) {
            return "If I grow too big I may become too much to handle...";

        } else {
            return "I'm small but perfectly formed.";
        }
    }
}
