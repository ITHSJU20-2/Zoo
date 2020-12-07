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
            return "If I felt like it, I could destroy you. Go watch Planet of the Apes.";
        } else return "I like you, haven't felt this loved since I met Michael Jackson!";
    }


    public String feed() {
        if (getLikes().contains(Food.FRUIT) || getLikes().contains(Food.BERRY)) {
            setXp(getXp() + 50);
            setSize(getSize() + 5);
            return liked;
        } else if (getLikes().contains(Food.MEAT)) {
            setXp(getXp() + 20);
            setSize(getSize() + 2);
            return tolerated;
        }
        if (getXp() > 50) {
            return "If I grow too big I may become too much to handle...";

        } else {
            return "I'm small but perfectly formed.";
        }
    }
}
