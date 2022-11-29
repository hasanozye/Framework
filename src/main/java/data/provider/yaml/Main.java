package data.provider.yaml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g"));

        YamlUtility config = YamlUtility.readYaml("src/main/resources/application.yaml");

        if (!config.getTestcases().equalsIgnoreCase("all")){
            String[] arr = config.getTestcases().split("[,.:;]");
            ArrayList<String> tc = new ArrayList<>(Arrays.stream(arr).map(String::trim).toList());
            list.removeIf(e->!tc.contains(e));
        }
        System.out.println(list);
        System.out.println(config.getDatabase().getDbname());

    }

    public static void writeYml(){
        YamlUtility yamlUtility = new YamlUtility();
        YamlUtility.Database database = yamlUtility.new Database();
        yamlUtility.setAuthor("Ahmet");
        yamlUtility.setUrl("https://google.com");
        database.setDbname("deneme");
        database.setPort(3306);
        database.setDriver("mysql");
        database.setUsername("user");
        database.setPassword("pass");
        yamlUtility.setDatabase(database);
        YamlUtility.writeYaml("src/main/resources/application1.yaml", yamlUtility);
        YamlUtility config1 = YamlUtility.readYaml("src/main/resources/application1.yaml");
        System.out.println(config1.toString());
    }
}
