package se.iths.grupp2.animals;

import java.util.List;

public abstract class SeaCreature extends Animal{

    private boolean dangerous;
    private String teeth;
    private String fins;

    public SeaCreature(String name, List<Food> likes, int xp, boolean dangerous, String teeth, String fins) {
        super(name, likes, xp);
        this.dangerous = dangerous;
        this.teeth = teeth;
        this.fins = fins;
    }
}

