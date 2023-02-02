package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddToCartPage extends BasePage {

     private String pageTitleLabel = "//*[@id=\"page-title-heading\"]/span"; //xpath
     private String filterProductsLabel = "//*[@id=\"amasty-shopby-product-list\"]/div[2]/div/div/strong";
     private String categoryLabel = "//*[@id=\"narrow-by-list\"]/div[1]/div/dt";
     private String priceLabel = "#narrow-by-list > div:nth-child(2) > div > dt";//css
     private String producerLabel = "#narrow-by-list > div:nth-child(3) > div > dt";
     private String productOrderingSelector = "#amasty-shopby-product-list > div:nth-child(1) > div.toolbar-sorter.sorter > label";
     private String dropDownSorterSelector = "//*[@id=\"sorter\"]";

     public AddToCartPage(WebDriver driver) {
          super(driver);
     }
     public void verifyAddToCartPage(){
          Assert.assertEquals(driver.findElement(By.xpath(pageTitleLabel)).getText(), "Gift Ideas");
          Assert.assertEquals(driver.findElement(By.xpath(filterProductsLabel)).getText(), "Filtreaza");
          Assert.assertEquals(driver.findElement(By.xpath(categoryLabel)).getText(), "CATEGORIE");
          Assert.assertEquals(driver.findElement(By.cssSelector(priceLabel)).getText(),"PRET");
          Assert.assertEquals(driver.findElement(By.cssSelector(producerLabel)).getText(), "PRODUCATOR");
          Assert.assertEquals(driver.findElement(By.cssSelector(productOrderingSelector)).getText(), "Ordoneaza");
     }

     public void setDropDownSorterSelector(){
          WebElement orderProductsDropdown = driver.findElement(By.xpath(dropDownSorterSelector));
          orderProductsDropdown.click();

     }
}
