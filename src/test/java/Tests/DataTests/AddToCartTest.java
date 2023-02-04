package Tests.DataTests;

import Pages.AddToCartPage;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

     @Test(priority = 1)
     public void verifyAddToCartTest(){
          driver.get(baseUrl + "/gift-ideas.html/");
          AddToCartPage acp = new AddToCartPage(driver);
          acp.verifyAddToCartPage();
     }

     @Test(priority = 1)
     public void orderProductsDropdownTest(){
          driver.get(baseUrl + "/gift-ideas.html/");
          AddToCartPage acp = new AddToCartPage(driver);
          acp.setDropDownSorterSelector();
     }
     @Test(priority = 1)
     public void clickOnProductTest(){
          driver.get(baseUrl + "/gift-ideas.html/");
          AddToCartPage lp = new AddToCartPage(driver);
          lp.clickOnTheProduct();
     }
     @Test
     public void addToCartTest(){
          clickOnProductTest();
          AddToCartPage atc = new AddToCartPage(driver);
          atc.addToCartProduct();
     }
}
