package denemeler.staleelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

public class TestStaleElementFindBy {

    WebDriver driver;
    String url = "https://opencart.abstracta.us/";

    @FindBy(xpath = "//input[@name='search']")
    WebElement searchInputFindBy;
    // bu element cagrildiginda create edilir.

    public TestStaleElementFindBy(){
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getDriver(), 10), this);
    }

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
    public void test1_StaleElement(){
        //WebElement e = searchInputFindBy;
        //WebElement e1 = driver.findElement(By.xpath("//input[@name='search']"));
        searchInputFindBy.sendKeys("mac");
        driver.navigate().refresh();

        searchInputFindBy.sendKeys("AAAAAAA");
    }

}
