package se.iths.grupp2.animals;

import java.util.List;

public class Chimpanzee extends Ape{
    public Chimpanzee(String name, List likes, int xp, int size, String colour) {
        super(name, likes, xp, size, colour);
    }

    public void pet() {
        System.out.println("Hi, I'm " + getName() + ". I like you, haven't felt this loved since I met Michael Jackson!");
    }

    public void feed() {
        setXp(getXp()+1);
        if (getXp() > 5) {
            System.out.println("If I grow too big I may become too much to handle...");
            setSize(getSize()+1);
        } else
        {
            System.out.println("I'm small but perfectly formed.");
        }
    }
}
