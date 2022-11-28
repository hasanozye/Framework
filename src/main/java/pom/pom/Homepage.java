package pom.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.Driver;

public class Homepage {

    WebDriver driver;

    String url = "http://opencart.abstracta.us/";

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchInput;

    @FindBy(css = "#search button")
    private WebElement searchButton;


    public Homepage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void gotoUrl(){
        driver.get(url);
    }

    public SearchPage search(String text){
        searchInput.sendKeys(text);
        searchButton.click();
        return new SearchPage();
    }

    public String getTitle(){
        return driver.getTitle();
    }







}
