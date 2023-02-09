package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AddToCartProductPage extends BasePage {

     private String pageTitleSelector = "#maincontent > div.columns > div:nth-child(1) > div.product-info-main > div.page-title-wrapper.product > h1 > span";
     private String productSelector = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[3]/div[1]/img";
     private String addToCartButtonSelector = "//*[@id=\"product-addtocart-button\"]";
     private String priceTagSelector = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[4]/div[2]/span[2]/span/span";
     private String phoneNumberSelector = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[6]/div/div/div[2]/a[1]";
     private String similarProductsTextSelector = "//*[@id=\"block-related-heading\"]";
     private String backToTopButton = "//*[@id=\"html-body\"]/div[3]/footer/div/div[6]/div/a";


     public AddToCartProductPage(WebDriver driver){
          super(driver);
     }

     public void verifyPage(){
          //Assert.assertEquals(driver.findElement(By.cssSelector(pageTitleSelector)), "Ceas STIHL TIMBERSPORTS negru");
          //Assert.assertEquals(driver.findElement(By.xpath(priceTagSelector)), "274,41LEI");
          //Assert.assertEquals(driver.findElement(By.xpath(phoneNumberSelector)), "0371.710.071");
          Assert.assertEquals(driver.findElement(By.xpath(similarProductsTextSelector)), "Produse similare");
     }
     public void addToCartProduct(){
          WebElement addToCartButton = driver.findElement(By.xpath(addToCartButtonSelector));
//          addToCartButton.click();
          Actions actions = new Actions(driver);
          actions.moveToElement(addToCartButton).click().build().perform();

     }

}
