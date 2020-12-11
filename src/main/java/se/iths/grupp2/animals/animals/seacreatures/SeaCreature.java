package se.iths.grupp2.animals.animals.seacreatures;

import se.iths.grupp2.animals.animals.Animal;
import se.iths.grupp2.animals.animals.Food;

import java.util.List;

public abstract class SeaCreature extends Animal {

    private boolean dangerous;
    private String teeth;
    private String fins;

    public SeaCreature(String name, List<Food> likes, int xp, boolean dangerous, String teeth, String fins) {
        super(name, likes, xp);
        this.dangerous = dangerous;
        this.teeth = teeth;
        this.fins = fins;
    }

    public boolean isDangerous() {
        return dangerous;
    }

    public void setDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }

    public String getTeeth() {
        return teeth;
    }

    public void setTeeth(String teeth) {
        this.teeth = teeth;
    }

    public String getFins() {
        return fins;
    }

    public void setFins(String fins) {
        this.fins = fins;
    }
}

