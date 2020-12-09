package se.iths.grupp2.animals.server;

import se.iths.grupp2.animals.Animal;
import se.iths.grupp2.animals.Food;
import se.iths.grupp2.animals.Main;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FeedPost extends HttpServlet {

    /*
     * From the post body we get the name of the animal in a string and convert it into the respective animal. As
     * well as the food source.
     * Then the feed method is run using the animal and food source. Then returns the message of "success" to the
     * webpage.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Food food = Food.valueOf(req.getParameter("food").toUpperCase());
        Animal animal = Main.getController().getAnimalByName(req.getParameter("animal"));
        boolean liked = Main.getController().feed(animal, food);
        PrintWriter writer = resp.getWriter();
        if (liked) {
            writer.append("success");
        } else {
            writer.append("error");
        }
    }
}
