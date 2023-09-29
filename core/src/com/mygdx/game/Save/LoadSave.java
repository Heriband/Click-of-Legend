package com.mygdx.game.Save;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadSave {
    JSONParser parser = new JSONParser();
    public LoadSave(String path){
        JSONObject obj = getJsonSave(path);
        if (obj == null || !((boolean) obj.get("loadSave")))
            return;
        JSONObject player = (JSONObject) obj.get("player");
        Long gold = (Long) player.get("gold");

        System.out.println("Gold: " + gold);

    }

    public JSONObject getJsonSave(String path){
        try (FileReader reader = new FileReader(path)) {
            // Parse the JSON file
            Object obj = parser.parse(reader);

            // Cast the parsed object to a JSON object
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject;

        } catch (IOException | ParseException e) {
            return null;
        }
    }

}
