package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.Message;
import org.openqa.selenium.remote.http.TextMessage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.MessageFormat;
import java.time.Duration;

public class Test1 {

    WebDriver driver;
    public static String XPAT_OF_INPUT = "//input[.//parent::div[.=\"{0}\" or ./*[.=\"{0}\"]]]";


    public static void main(String[] args) {
        System.out.println(MessageFormat.format(XPAT_OF_INPUT, "User Name"));
    }


    @BeforeTest
    public void beforeTest(){
        driver = Driver.getDriver();
    }

    @Test
    @Parameters({"url"})
    public void test1(String url) {
        driver.get(url);
    }

    @Test
    public void testDeneme(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver)->{
            try {
                driver.findElement(By.xpath("")).click();
                return true;
            }catch (Exception e){
                return false;
            }
        });
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


    /*
        Given write "aaa" to "User Name"


        //input[.//parent::div[.='User Name' or ./*[.='User Name']]]

     */
}
