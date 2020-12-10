package se.iths.grupp2.animals.server;

import se.iths.grupp2.animals.Animal;
import se.iths.grupp2.animals.Main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeletePost extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Animal animal = Main.getController().getAnimalByName(req.getParameter("animal"));
        boolean removed = Main.getController().getAnimals().remove(animal);
        PrintWriter writer = resp.getWriter();
        if (removed) {
            writer.append("success");
        } else {
            writer.append("error");
        }
    }
}
