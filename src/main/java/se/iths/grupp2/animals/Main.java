package se.iths.grupp2.animals;

import se.iths.grupp2.animals.animals.AnimalController;
import se.iths.grupp2.animals.storage.DataManager;

public class Main {

    public static AnimalController controller = new AnimalController();

    private static final DataManager dataManager = new DataManager();

    public static AnimalController getController() {
        return controller;
    }

    public static DataManager getDataManager() {
        return dataManager;
    }
}
