package pom.pom;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {

    Homepage homepage;
    SearchPage searchPage;

    @Test
    public void test1(){
        homepage = new Homepage();
        homepage.gotoUrl();
        searchPage = homepage.search("mac");
        Assert.assertEquals(homepage.getTitle(), "Your Store");
    }

    @Test
    public void test(){
        Assert.assertEquals(searchPage.getProductNumber(), 4);
    }
}
