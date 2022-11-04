package PoolGame.config;

import PoolGame.GameManager;
import PoolGame.objects.Pocket;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PocketReader implements Reader{
    @Override
    public void parse(String path, GameManager gameManager) {
        gameManager.getTable().clearAll();
        JSONParser parser = new JSONParser();
        try{
            Object object = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonTable = (JSONObject) jsonObject.get("Table");
            JSONArray jsonPockets = (JSONArray) jsonTable.get("pockets");
            for(Object obj: jsonPockets){
                JSONObject pocket = (JSONObject) obj;
                Double radius  = (Double) pocket.get("radius");
                Double positionX = (Double) ((JSONObject) pocket.get("position")).get("x");
                Double positionY = (Double) ((JSONObject) pocket.get("position")).get("y");
                Pocket p = new Pocket(positionX, positionY, radius);
                gameManager.getTable().addPocket(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
