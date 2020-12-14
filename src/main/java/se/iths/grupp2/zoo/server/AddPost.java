package se.iths.grupp2.zoo.server;

import se.iths.grupp2.zoo.Main;
import se.iths.grupp2.zoo.animals.Animal;
import se.iths.grupp2.zoo.animals.Food;
import se.iths.grupp2.zoo.animals.ape.Chimpanzee;
import se.iths.grupp2.zoo.animals.ape.Gorilla;
import se.iths.grupp2.zoo.animals.ape.Orangutan;
import se.iths.grupp2.zoo.animals.bird.Eagle;
import se.iths.grupp2.zoo.animals.bird.Ostrich;
import se.iths.grupp2.zoo.animals.bird.Pigeon;
import se.iths.grupp2.zoo.animals.canine.Coyote;
import se.iths.grupp2.zoo.animals.canine.Dog;
import se.iths.grupp2.zoo.animals.canine.Wolf;
import se.iths.grupp2.zoo.animals.feline.Cat;
import se.iths.grupp2.zoo.animals.feline.Lion;
import se.iths.grupp2.zoo.animals.seacreatures.Goldfish;
import se.iths.grupp2.zoo.animals.seacreatures.Shark;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class AddPost extends HttpServlet {

    /*
     * From the post body we get the name of the animal in a string and check if there exists an animal with that
     * name in the animal list in the AnimalController. In a switch statement we go through the name of the animal
     * and then add the respective animal. Then returns "success" if the animal doesn't already exist.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String animalName = req.getParameter("animal");
        Animal animal;
        if (Main.getController().getAnimalByName(animalName) != null) {
            PrintWriter writer = resp.getWriter();
            writer.append("That animal already exists");
            return;
        }
        switch (animalName) {
            // Tobias' Birds
            case "Eagle":
                animal = new Eagle("Eagle", Arrays.asList(Food.BERRY, Food.FRUIT), 0, true, "Skreaaaaagh");
                break;
            case "Ostrich":
                animal = new Ostrich("Ostrich", Arrays.asList(Food.FRUIT), 0, false, "EuhehuHeuEhEuEh");
                break;
            case "Pigeon":
                animal = new Pigeon("Pigeon", Arrays.asList(Food.VEGETABLE), 0, true, "Kurrkurr");
                break;
            // Marcus' Feline
            case "Cat":
                animal = new Cat("Cat",Arrays.asList(Food.MEAT),0,false,"Mjaauu");
                break;
            case "Lion":
                animal = new Lion("Lion",Arrays.asList(Food.MEAT),0,true,"RoOAAAR");
                break;
            // Sean's Canines
            case "Wolf":
                animal = new Wolf("Wolf",Arrays.asList(Food.MEAT),0,false,true);
                break;
            case "Coyote":
                animal = new Coyote("Coyote",Arrays.asList(Food.MEAT),0,true,false);
                break;
            case "Dog":
                animal = new Dog("Dog",Arrays.asList(Food.MEAT),0,true, true);
                break;
            //Tom's Apes
            case "Gorilla":
                animal = new Gorilla("Gorilla", Arrays.asList(Food.MEAT, Food.FRUIT, Food.BERRY), 0, 0,
                        "Silver and black");
                break;
            case "Orangutan":
                animal = new Orangutan("Orangutan", Arrays.asList(Food.VEGETABLE, Food.FRUIT, Food.BERRY),
                        0, 0, "Orange");
                break;
            case "Chimpanzee":
                animal = new Chimpanzee("Chimpanzee", Arrays.asList(Food.MEAT, Food.FRUIT, Food.BERRY),
                        0, 0, "Black");
                break;

            // Kabbe's Sea Creatures
            case "Shark":
                animal = new Shark("Shark", Arrays.asList(Food.MEAT), 0, false, "sharp",
                        "stealthy", "CHEW");
                break;
            case "Goldfish":
                animal = new Goldfish("Goldfish", Arrays.asList(Food.VEGETABLE), 0, false,
                        "minimal", "small", true);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + animalName);
        }
        Main.getController().getAnimals().add(animal);
        PrintWriter writer = resp.getWriter();
        writer.append("success");
    }
}