package se.iths.grupp2.zoo;

import se.iths.grupp2.zoo.animals.AnimalController;
import se.iths.grupp2.zoo.storage.DataManager;

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
