package se.iths.grupp2.animals.server;

import se.iths.grupp2.animals.Main;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;

public class LoadPost extends HttpServlet {

    /*
     * Tries to load the gamedata from the post body.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (!req.getParameter("data").equals("")) {
            try {
                Main.getDataManager().saveToFiles(req.getParameter("data"));
                Main.getDataManager().loadFromFiles();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
