package se.iths.grupp2.animals.server;

import se.iths.grupp2.animals.Main;
import se.iths.grupp2.animals.animals.Animal;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PetPost extends HttpServlet {

    /*
     * From the post body we get the name of the animal in a string and convert it into the respective animal.
     * Then the pet method is run using the animal. Then returns the message of "success" to the webpage.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Animal animal = Main.getController().getAnimalByName(req.getParameter("animal"));
        boolean success = Main.getController().pet(animal);
        PrintWriter writer = resp.getWriter();
        if (success) {
            writer.append("success");
        } else
            writer.append("error");
    }
}
