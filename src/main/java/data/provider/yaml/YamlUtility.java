package data.provider.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class  YamlUtility {

    public static YamlUtility readYaml(String path){
        YamlUtility yamlUtility;
        File file = new File(path);
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            yamlUtility = objectMapper.readValue(file, YamlUtility.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return yamlUtility;
    }


    public static void writeYaml(String path, YamlUtility yamlUtility){

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            objectMapper.writeValue(new File(path), yamlUtility);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public YamlUtility(){

    }

    private String author;
    private String url;
    private String testcases;
    private Database database;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTestcases() {
        return testcases;
    }

    public void setTestcases(String testcases) {
        this.testcases = testcases;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public class Database {
        private String driver;
        private Integer port;
        private String dbname;
        private String username;
        private String password;

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }

        public String getDbname() {
            return dbname;
        }

        public void setDbname(String dbname) {
            this.dbname = dbname;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }

}
