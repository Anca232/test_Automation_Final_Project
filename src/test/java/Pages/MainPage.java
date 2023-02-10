package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class MainPage extends BasePage {

     private String mainPageLogo = "//*[@id=\"html-body\"]/div[3]/header/div[2]/strong/img "; //css
     private String searchProductSelector = "//*[@id=\"search\"]"; //xpath

     private String myAccountOptionSelector = "#idAZqmoaHI"; //css
     private String hoverIconSelector = "//*[@id=\"html-body\"]/div[3]/header/div[2]/ul/button/a/img"; //xpath
     private String shoppingCartSelector = "#minicart > a";
     private String searchButtonSelector = "//*[@id=\"algolia-glass\"]"; //xpath
     private String loginButtonSelector = "//*[@id=\"html-body\"]/div[3]/header/div[2]/ul/div/ul/li[1]/a"; //xpath
     private String alertButtonSelector = "#html-body > div.amgdprcookie-bar-template > div > div > p"; //css

     public MainPage(WebDriver driver) {
          super(driver);
     }

     public void searchBar(String product){
          WebElement searchBarInput = driver.findElement(By.xpath(searchProductSelector));
          searchBarInput.click();

          searchBarInput.clear();
          searchBarInput.sendKeys(product);
     }
     public void clickOnAlertButton(){
          WebElement cookieButton = driver.findElement(By.cssSelector(alertButtonSelector));
          cookieButton.click();
     }

     public void goToShoppingCartPage(){
          driver.findElement(By.cssSelector(shoppingCartSelector)).click();
          Assert.assertEquals(driver.findElement(By.cssSelector(shoppingCartSelector)).getText(), "COSUL DE CUMPARATURI");
     }

     public void clickOnSearchButton(){
          driver.findElement(By.xpath(searchButtonSelector));
     }

     public void clickOnSignIn(){
          WebElement hoverOption = SeleniumUtils.waitForGenericElement(driver, By.xpath(hoverIconSelector), 10);
          hoverOption.click();
          Actions actions = new Actions(driver);
          actions.moveToElement(hoverOption).build().perform();
          driver.findElement(By.xpath(loginButtonSelector)).click();
     }
}
