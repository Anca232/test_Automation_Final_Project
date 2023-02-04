package Tests.DataTests;

import Pages.AddToCartPage;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

     @Test
     public void verifyAddToCartTest(){
          driver.get(baseUrl + "/gift-ideas.html/");
          AddToCartPage acp = new AddToCartPage(driver);
          acp.verifyAddToCartPage();
     }

     @Test
     public void orderProductsDropdownTest(){
          driver.get(baseUrl + "/gift-ideas.html/");
          AddToCartPage acp = new AddToCartPage(driver);
          acp.setDropDownSorterSelector();
     }
}
