package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if (drivers.get() == null) {
            WebDriverManager.chromedriver().setup();
            drivers.set(new ChromeDriver());
        }
        return drivers.get();
    }


    public static void quitDriver(){
        if (drivers.get() != null)
            drivers.get().quit();
    }


}
