package pom.locator.usage;

import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

import java.text.MessageFormat;

public class TestPage {

    WebDriver driver;
    String url = "https://opencart.abstracta.us/";
    By lSearchInput = By.xpath("//input[@name='search']");

    By lSearchButton = By.cssSelector("#search button");

    public static final String XPATH = "(//div[@class=\"product-thumb\" and .//a[.=\"{0}\"]]//a)[2]";
    //public static final String XPATH = "(//div[@class='product-thumb' and .//a[.='MacBook']]//a)[2]";

    @BeforeTest
    public void beforeTest(){
        driver  = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(lSearchInput).sendKeys("mac");
        driver.findElement(lSearchButton).click();
        scrollBy(500);
        clickToProduct("MacBook");

        Thread.sleep(5000);
    }

    public void clickToProduct(String productName){
        String xpath = MessageFormat.format(XPATH, productName);
        WebElement product = driver.findElement(By.xpath(xpath));
        scrollIntoView(product);
        product.click();
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


    public void scrollIntoView(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollBy(int y){
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + y + ");");
    }




}
