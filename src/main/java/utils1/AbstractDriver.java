package utils1;

import org.openqa.selenium.WebDriver;

public abstract class AbstractDriver {
    protected WebDriver driver;

    public abstract WebDriver getDriver();

    public void quitDriver(){
        if (driver != null)
            driver.quit();
    }

}
