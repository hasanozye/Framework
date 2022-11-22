package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test2 {

    WebDriver driver;


    @Test
    public void test1() {
        driver = DriverSingleton.getDriver();
        driver.get("https://google.com");
        driver = DriverSingleton.getDriver();
        driver.quit();
        DriverSingleton.quitDriver();

    }


    @Test
    public void test2() {
        driver = DriverSingleton.getDriver();
        driver.get("https://google.com");
        driver = DriverSingleton.getDriver();
        driver.quit();
        DriverSingleton.quitDriver();

    }

    public void write(String str){
        write(str, 1);
    }

    public void write(String str, int num){
        for (int i = 0; i < num; i++) {
            System.out.println(str);
        }

    }
}
