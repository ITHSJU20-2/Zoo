package se.iths.grupp2.animals;

import java.util.List;

public class Gorilla extends Ape {
    public Gorilla(String name, List likes, int xp, int size, String colour) {
        super(name, likes, xp, size, colour);
    }

    public void pet() {
        System.out.println("Dude, really? Petting me? The mighty " + getName() + "? You got a death wish?!");
    }

    public void feed() {
        if (getXp() > 5) {
            System.out.println("I am the strongest of all apes. Admire my mighty growth.");
            setSize(getSize()+1);
        } else
        {
            System.out.println("I'm still growing.");
        }
    }
}
