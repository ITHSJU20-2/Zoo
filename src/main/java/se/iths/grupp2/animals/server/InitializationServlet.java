package se.iths.grupp2.animals.server;

import se.iths.grupp2.animals.Main;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class InitializationServlet implements ServletContextListener {

    /*
     * Whenever the server starts we try to load the gamedata from the animals.txt file.
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            Main.getDataManager().loadFromFiles();
        } catch (URISyntaxException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
     * Whenever the server shuts down we try to save the gamedata to the animals.txt file.
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        try {
            Main.getDataManager().saveToFiles();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
