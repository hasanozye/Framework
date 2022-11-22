package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {

    WebDriver driver;


    @BeforeTest
    public void beforeTest(){
        driver = Driver.getDriver();
    }

    @Test
    @Parameters({"url"})
    public void test1(String url) {
        driver.get(url);
    }

    @AfterTest
    public void afterTest(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
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
