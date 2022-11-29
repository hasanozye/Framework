package data.provider.property;


public class Main {
    public static void main(String[] args) {

        PropertyUtility prop = PropertyUtility.load("src/main/resources/prop1.properties");
        prop.put("a", "a");
        prop.put("a", "a");
        prop.put("b", "b");
        prop.put("a", "a");

        prop.remove("b");
        prop.update("a", "aa");
        prop.write();


    }
}
