package se.iths.grupp2.animals;

import java.util.List;
//Wolf Subclass
public class Wolf extends Canine{
    public Wolf(String name, List<Food> dislikes, List<Food> likes, int xp, boolean howling) {
        super(name, dislikes, likes, xp, howling);
    }
}
