package se.iths.grupp2.animals.server;

import se.iths.grupp2.animals.*;

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
                animal = new Ostrich("Ostrich", Arrays.asList(Food.FRUIT), 0, false, "???");
                break;
            case "Pigeon":
                animal = new Pigeon("Pigeon", Arrays.asList(Food.VEGETABLE), 0, true, "kurrkurr");
                break;
            // Marcus' Feline
            // Sean's Forest Creatures
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
            default:
                throw new IllegalStateException("Unexpected value: " + animalName);
        }
        Main.getController().getAnimals().add(animal);
        PrintWriter writer = resp.getWriter();
        writer.append("success");
    }
}
