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
    WebElement searchInput;

    @FindBy(css = "#search button")
    WebElement searchButton;




    public Homepage(){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void gotoUrl(){
        driver.get(url);
    }

    public void search(){

    }







}
