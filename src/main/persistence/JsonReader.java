package persistence;

import model.PCLists;
import model.PC;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads PCList from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads PCList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public PCLists read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parsePCLists(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses PCList from JSON object and returns it
    private PCLists parsePCLists(JSONObject jsonObject) {
        PCLists pcList = new PCLists();
        addPCs(pcList, jsonObject);
        return pcList;
    }

    // MODIFIES: pcList
    // EFFECTS: parses thingies from JSON object and adds them to PCList
    private void addPCs(PCLists pcList, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("pcList");
        for (Object json : jsonArray) {
            JSONObject nextPC = (JSONObject) json;
            addPC(pcList, nextPC);
        }
    }

    // MODIFIES: pcList
    // EFFECTS: parses thingy from JSON object and adds it to PCList
    private void addPC(PCLists pcList, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        PC pc = new PC(name);
        pcList.addPC(pc);
    }
}