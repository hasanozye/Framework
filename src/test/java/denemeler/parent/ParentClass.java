package denemeler.parent;

import org.openqa.selenium.WebDriver;
import utils1.ChromeDriverFactory;

public class ParentClass {

    WebDriver driver;

    // instance initializer
    {
        driver = new ChromeDriverFactory().getDriver();
    }

}
