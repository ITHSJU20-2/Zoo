package se.iths.grupp2.animals.server;

import se.iths.grupp2.animals.Main;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class InitializationServlet implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            Main.getDataManager().loadFromFiles();
        } catch (URISyntaxException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        try {
            Main.getDataManager().saveToFiles();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
