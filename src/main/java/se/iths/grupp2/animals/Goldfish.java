package se.iths.grupp2.animals;

import java.util.List;

public class Goldfish extends SeaCreature {

    private boolean dumb;

    public Goldfish(String name, List<Food> likes, int xp, boolean dangerous, String teeth, String fins, boolean dumb) {
        super(name, likes, xp, dangerous, teeth, fins);
        this.dumb = dumb;
    }
}
