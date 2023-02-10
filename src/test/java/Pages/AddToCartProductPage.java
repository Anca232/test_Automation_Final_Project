package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AddToCartProductPage extends BasePage {

     private String addToCartButtonSelector = "//*[@id=\"product-addtocart-button\"]";

     public AddToCartProductPage(WebDriver driver){
          super(driver);
     }

     public void addToCartProduct(){
          WebElement addToCartButton = driver.findElement(By.xpath(addToCartButtonSelector));
          Actions actions = new Actions(driver);
          actions.moveToElement(addToCartButton).click().build().perform();
     }
}
