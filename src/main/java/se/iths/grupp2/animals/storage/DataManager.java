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

    public void saveToFiles() throws IOException, URISyntaxException {
        String json = gson.toJson(Main.getController().getAnimals());
        // Save json string to file
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

    public void saveToFiles(String json) throws IOException, URISyntaxException {
        // Save json string to file
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

    public String getData() throws FileNotFoundException, URISyntaxException {
        // Load json string from file
        URL resource = Main.class.getClassLoader().getResource("animals.txt");
        File file;
        if (resource == null) {
            throw new FileNotFoundException("animals.txt not found");
        } else {
            file = new File(resource.toURI());
        }
        String json = "";
        try {
            json = String.join("\n", Files.readAllLines(file.toPath(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (json.equals("")) {
            return "";
        } else {
            return json;
        }
    }

    public void loadFromFiles() throws URISyntaxException, FileNotFoundException {
        // Load json string from file
        URL resource = Main.class.getClassLoader().getResource("animals.txt");
        File file;
        if (resource == null) {
            throw new FileNotFoundException("animals.txt not found");
        } else {
            file = new File(resource.toURI());
        }
        String json = "";
        try {
            json = String.join("\n", Files.readAllLines(file.toPath(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

}