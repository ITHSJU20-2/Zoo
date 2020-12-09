package se.iths.grupp2.animals.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import se.iths.grupp2.animals.Animal;
import se.iths.grupp2.animals.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private final Gson gson = new Gson();

    /**
     * Convert the animal List (AnimalController#animals) to a json string and save it to the animals.txt file if it
     * could be found.
     *
     * @throws IOException        If the file is not found or the FileWriter cannot be created properly.
     * @throws URISyntaxException If the resource cannot be turned into a URI.
     */
    public void saveToFiles() throws IOException, URISyntaxException {
        String json = gson.toJson(Main.getController().getAnimals());
        // Save json string to file
        save(json);
    }

    /**
     * Save the json parameter to the animals.txt file if it could be found.
     *
     * @param json The json string to save to the animals.txt file.
     * @throws IOException        If the file is not found or the FileWriter cannot be created properly.
     * @throws URISyntaxException If the resource cannot be turned into a URI.
     */
    public void saveToFiles(String json) throws IOException, URISyntaxException {
        // Save json string to file
        save(json);
    }

    private void save(String json) throws URISyntaxException, IOException {
        URL resource = Main.class.getClassLoader().getResource("animals.txt");
        File file;
        if (resource == null) {
            throw new FileNotFoundException("animals.txt not found");
        } else {
            file = new File(resource.toURI());
        }
        FileWriter writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    /**
     * Returns the current gamedata as a json string.
     *
     * @return JSON string of the current gamedata.
     * @throws URISyntaxException    If the resource cannot be turned into a URI.
     * @throws FileNotFoundException If the file is not found.
     */
    public String getData() throws FileNotFoundException, URISyntaxException {
        // Load json string from file
        String json = load();
        if (json.equals("")) {
            return "";
        } else {
            return json;
        }
    }

    /**
     * From the animals.txt file (if found) load the data from it to the animal list in AnimalController
     *
     * @throws URISyntaxException    If the resource cannot be turned into a URI.
     * @throws FileNotFoundException If the file is not found.
     */
    public void loadFromFiles() throws URISyntaxException, FileNotFoundException {
        // Load json string from file
        String json = load();
        Type type = new TypeToken<List<Animal>>() {
        }.getType();
        List<Animal> animals;
        if (json.equals("")) {
            animals = new ArrayList<>();
        } else {
            animals = gson.fromJson(json, type);
        }
        Main.getController().setAnimals(animals);
    }

    private String load() throws FileNotFoundException, URISyntaxException {
        URL resource = Main.class.getClassLoader().getResource("animals.txt");
        File file;
        if (resource == null) {
            throw new FileNotFoundException("animals.txt not found");
        } else {
            file = new File(resource.toURI());
        }
        try {
            return String.join("\n", Files.readAllLines(file.toPath(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}