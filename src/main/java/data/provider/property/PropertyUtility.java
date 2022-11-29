package data.provider.property;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class PropertyUtility {

    private String filePath;
    private Properties properties = new Properties();
    private FileReader fileReader;
    private FileWriter fileWriter;


    public static PropertyUtility load(String filePath) {
        return new PropertyUtility(filePath).load();
    }

    private PropertyUtility(String filePath) {
        this.filePath = filePath;
    }

    private PropertyUtility load() {
        try {
            fileReader = new FileReader(filePath);
            fileWriter = new FileWriter(filePath);
            properties.load(fileReader);
        } catch (IOException e) {
            try {
                fileReader = new FileReader(filePath);
                properties.load(fileReader);
            }catch (Exception e1){
                throw new RuntimeException(e1);
            }
        }
        return this;
    }

    public PropertyUtility update(String key, String value){
        properties.setProperty(key, value);
        return this;
    }


    public PropertyUtility write(){
        try {
            properties.store(fileWriter, "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

    public PropertyUtility put(String key, String value) {
        properties.setProperty(key, value);
        return this;
    }

    public PropertyUtility remove(String key) {
        properties.remove(key);
        return this;
    }
}
