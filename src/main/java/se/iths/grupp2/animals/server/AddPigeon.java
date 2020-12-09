package se.iths.grupp2.animals.server;

import se.iths.grupp2.animals.Food;
import se.iths.grupp2.animals.Main;
import se.iths.grupp2.animals.Pigeon;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class AddPigeon extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Main.getController().getAnimals().add(new Pigeon("Pigeon", Arrays.asList(Food.VEGETABLE), 0, true, "kurrkurr"));
    }
}
