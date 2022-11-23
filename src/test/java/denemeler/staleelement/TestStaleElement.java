package denemeler.staleelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

public class TestStaleElement {

    WebDriver driver;
    String url = "https://opencart.abstracta.us/";
    By lSearchInput = By.xpath("//input[@name='search']");


    @BeforeTest
    public void beforeTest(){
        driver  = Driver.getDriver();
        driver.get(url);
    }

    @AfterTest
    public void AfterTest(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void test1(){
        WebElement searchInput = driver.findElement(lSearchInput);
        driver.navigate().refresh();
        searchInput = driver.findElement(lSearchInput);
        searchInput.sendKeys("mac");
    }
}
