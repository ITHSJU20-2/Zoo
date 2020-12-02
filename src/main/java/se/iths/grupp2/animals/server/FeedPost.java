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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*
        Body:
            animal (name)
            food
         */
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
