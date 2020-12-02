package se.iths.grupp2.animals.server;

import se.iths.grupp2.animals.Animal;
import se.iths.grupp2.animals.Main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PetPost extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        Body:
            animal (name)
         */
        Animal animal = Main.getController().getAnimalByName(req.getParameter("animal"));
        Main.getController().pet(animal);
        PrintWriter writer = resp.getWriter();
        writer.append("success");
    }
}
