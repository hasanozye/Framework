package data.provider.json;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String jsonFile = "src/main/resources/JSONExample2.json";
        JSONUtility jsonWrite = JSONUtility.writeJSON(jsonFile);
        jsonWrite.put("adi", "John");
        jsonWrite.put("soyadi", "Smith");
        jsonWrite.put("memleket", "Ist");
        Map<Object, Object> adress = new HashMap(
                Map.of("streetAddress", "21 2nd Street",
                        "city", "New York",
                        "state", "NY",
                        "okul","okul",
                        "postalCode",10021)
        );
        jsonWrite.put("address", adress);
        jsonWrite.put("age", 25);
        Map<String, String> t1 = new HashMap<>(Map.of("type", "home", "number", "212 555-1234"));
        Map<String, String> t2 = new HashMap<>(Map.of("type", "fax", "number", "212 555-1234"));
        Map<String, String> t3 = new HashMap<>(Map.of("type", "mobil", "number", "211 555-1234"));
        jsonWrite.putArray("phoneNumbers", t1, t2, t3);

        jsonWrite.write();

        JSONUtility jsonRead = JSONUtility.readJSON(jsonFile);
        System.out.println(jsonRead.getVal("firstName").asString());
        System.out.println(jsonRead.getVal("memleket").asString());
        System.out.println(jsonRead.getVal("address").asMap());
        System.out.println(jsonRead.getVal("phoneNumbers").asArray());
    }
}
