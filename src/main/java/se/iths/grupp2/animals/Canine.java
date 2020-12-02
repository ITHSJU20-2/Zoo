package se.iths.grupp2.animals;

public class Canine extends Animal{

        private boolean barking;
        private boolean howling;

        public Canine(String name, List<Food> dislikes, List<Food> likes, int xp, boolean barking, boolean howling) {
            super(name, dislikes, likes, xp);
            this.barking() = barking;
            this.howling() = howling;
        }

        public boolean isBarking() {
            return barking;
        }

        public boolean isHowling() {
            return howling;
        }
    }
}
