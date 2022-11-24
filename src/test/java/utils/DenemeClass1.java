package utils;

import org.openqa.selenium.WebDriver;
import utils1.AbstractDriver;

public class DenemeClass1 {

    public static void main(String[] args) {
        AbstractDriver ad = new AbstractDriver() {
            @Override
            public WebDriver getDriver() {
                return null;
            }
        };
    }
}
