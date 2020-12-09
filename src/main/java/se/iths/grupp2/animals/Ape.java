package se.iths.grupp2.animals;

import java.util.List;

public abstract class Ape extends Animal {
    private int size;
    private final String colour;


    public Ape(String name, List<Food> likes, int xp, int size, String colour) {
        super(name, likes, xp);
        this.size = size;
        this.colour = colour;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }


    public String getColour() {
        return colour;
    }
}
