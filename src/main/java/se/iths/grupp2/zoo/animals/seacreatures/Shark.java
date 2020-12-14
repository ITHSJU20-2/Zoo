package se.iths.grupp2.zoo.animals.seacreatures;

import se.iths.grupp2.zoo.animals.Food;

import java.util.List;

public class Shark extends SeaCreature {

    private String chew;


    public Shark(String name, List<Food> likes, int xp, boolean dangerous, String teeth, String fins, String chew) {
        super(name, likes, xp, dangerous, teeth, fins);
        this.chew = chew;
    }

    public void pet (){
        System.out.println("Really, you tried petting a shark? You just lost an arm");
    }

    public void feed (){
        setXp((getXp()) + 10);
        if (getXp() > 100){
            System.out.println("Thank you for feeding me, soon I'll be big enough to eat you" );
        }
    }



    public String getChew() {
        return chew;
    }

    public void setChew(String chew) {
        this.chew = chew;
    }
}
