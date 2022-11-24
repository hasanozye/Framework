package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 {

    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = DriverSingleton.getDriver();
    }


    @AfterTest
    public void afterTest(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


    @Test
    public void test1() {
        driver.get("https://demowebshop.tricentis.com/login");

        WebElement labelEMail = driver.findElement(By.xpath("//label[.='Email:']"));
        By name = RelativeLocator.with(By.tagName("input")).toRightOf(labelEMail);
        driver.findElement(name).sendKeys("Ahmet");
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
