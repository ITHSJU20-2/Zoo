package se.iths.grupp2.animals.server;

import se.iths.grupp2.animals.Main;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;

public class SavePost extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Main.getDataManager().saveToFiles();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
