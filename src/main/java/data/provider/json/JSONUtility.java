package data.provider.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class JSONUtility {

    public static JSONUtility readJSON(String jsonFile){
        return new JSONUtility(jsonFile, false);
    }

    public static JSONUtility writeJSON(String jsonFile){
        return new JSONUtility(jsonFile, true);
    }

    private JSONObject jsonObject;
    private String jsonFile;
    private String key;

    private JSONUtility(String jsonFile){
        this(jsonFile, false);
    }

    private JSONUtility(String jsonFile, boolean write){
        this.jsonFile = jsonFile;
        if (write){
            jsonObject = new JSONObject();
        }else {
            try {
                jsonObject = (JSONObject) new JSONParser().parse(new FileReader(jsonFile));
            } catch (IOException | ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public JSONUtility getVal(String key){
        this.key = key;
        return this;
    }

    public int asInt(){
        return (int)jsonObject.get(key);
    }

    public double asDouble(){
        return (double)jsonObject.get(key);
    }

    public String asString(){
        return (String) jsonObject.get(key);
    }

    public Object asMap(){
        return jsonObject.get(key);
    }

    public Object asArray(){
        return  jsonObject.get(key);
    }

    public JSONUtility put(String key, Object value){
        jsonObject.put(key, value);
        return this;
    }

    public JSONUtility putArray(String key, Object...value){
        JSONArray arr = new JSONArray();
        for (Object map : value) {
            arr.add(map);
        }
        jsonObject.put(key, arr);
        return this;
    }


    public void write(){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(jsonFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pw.write(jsonObject.toJSONString());
        pw.flush();
        pw.close();
    }


}
