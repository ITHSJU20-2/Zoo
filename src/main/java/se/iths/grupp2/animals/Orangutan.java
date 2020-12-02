package se.iths.grupp2.animals;

import java.util.List;

public class Orangutan extends Ape {
    private static String liked;
    public Orangutan(String name, List likes, int xp, int size, String colour, String liked) {
        super(name, likes, xp, size, colour);
        liked = "I prefer tacos, but this'll do.";
    }

    public static String getLiked() {
        return liked;
    }

    public void pet() {
        System.out.println("My name is " + getName() + ". Clyde is my brother. You may have seen him with Clint Eastwood. So don't get too close.");
    }

    public void feed() {
        setXp(getXp()+1);
        if (getXp() > 5) {
            System.out.println("I am the smartest of all the great apes. My brain grows ever more powerful...");
            setSize(getSize()+1);
        } else
        {
            System.out.println("I'm still growing but my arms are still longer than yours.");
        }
    }
}
