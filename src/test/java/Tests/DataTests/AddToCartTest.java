package Tests.DataTests;

import Pages.AddToCartPage;
import Pages.AddToCartProductPage;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

     @Test(priority = 1)
     public void verifyAddToCartTest(){
          driver.get(baseUrl + "/gift-ideas.html/");
          AddToCartPage acp = new AddToCartPage(driver);
          acp.verifyAddToCartPage();
     }

     @Test (priority = 1)
     public void orderProductsDropdownTest(){
          driver.get(baseUrl + "/gift-ideas.html/");
          AddToCartPage acp = new AddToCartPage(driver);
          acp.setDropDownSorterSelector();
     }

     @Test
     public void numberOfProductOnThePageTest(){
          driver.get(baseUrl + "/gift-ideas.html/");
          AddToCartPage acp = new AddToCartPage(driver);
          acp.clickOnTheNumberProductDropDown();
     }
     @Test(priority = 1)
     public void clickOnProductTest(){
          driver.get(baseUrl + "/gift-ideas.html/");
          AddToCartPage lp = new AddToCartPage(driver);
          lp.clickOnTheProduct();
     }
     @Test
     public void addToCartTest(){
          driver.get(baseUrl + "/ceas-stihl-timbersports-negru.html/");
          AddToCartProductPage atc = new AddToCartProductPage(driver);
          atc.addToCartProduct();
     }
}
