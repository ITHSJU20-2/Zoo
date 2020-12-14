package se.iths.grupp2.zoo.server;

import se.iths.grupp2.zoo.Main;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;

public class SavePost extends HttpServlet {

    /*
     * Tries to save the current gamedata to the animals.json file.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Main.getDataManager().saveToFiles();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
