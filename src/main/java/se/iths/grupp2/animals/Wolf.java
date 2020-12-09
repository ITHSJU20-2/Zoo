package se.iths.grupp2.animals;

import java.util.List;
//Wolf Subclass
public class Wolf extends Canine{
    public Wolf(String name, List<Food> likes, int xp,boolean barking, boolean howling) {
        super(name, likes, xp, barking, howling);
    }
}
