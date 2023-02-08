package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AddToCartPage extends BasePage {

     private String pageTitleLabel = "//*[@id=\"page-title-heading\"]/span"; //xpath
     private String filterProductsLabel = "//*[@id=\"amasty-shopby-product-list\"]/div[2]/div/div/strong";
     private String categoryLabel = "//*[@id=\"narrow-by-list\"]/div[1]/div/dt";
     private String priceLabel = "#narrow-by-list > div:nth-child(2) > div > dt";//css
     private String producerLabel = "#narrow-by-list > div:nth-child(3) > div > dt";
     private String productOrderingSelector = "#amasty-shopby-product-list > div:nth-child(1) > div.toolbar-sorter.sorter > label";
     private String dropDownSorterSelector = "//*[@id=\"sorter\"]";
     private String dropDownNumberOfProductOnThePageTextSelector = "//*[@id=\"amasty-shopby-product-list\"]/div[1]/div[3]/label/span"; //path
     private String dropDownNumberOfProductOnThePageSelector = "//*[@id=\"limiter\"]";
     private String firstProductInTheListSelector = "//*[@id=\"amasty-shopby-product-list\"]/div[3]/ol/li[1]/div/a/span/span/picture/img";

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
          Assert.assertEquals(driver.findElement(By.xpath(dropDownNumberOfProductOnThePageTextSelector)).getText(), "Arata");
     }

     public void setDropDownSorterSelector(){
          WebElement orderProductsDropdown = driver.findElement(By.xpath(dropDownSorterSelector));
          orderProductsDropdown.click();
     }
     public void clickOnTheProduct(){
          WebElement hoverOption = driver.findElement(By.xpath(firstProductInTheListSelector));
          hoverOption.click();
     }
     public void clickOnTheNumberProductDropDown(){
          WebElement noOfProduct = driver.findElement(By.xpath(dropDownNumberOfProductOnThePageSelector));
          noOfProduct.click();
     }

}
