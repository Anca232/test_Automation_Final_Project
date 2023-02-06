package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountOptionsPage extends BasePage {

     private String myAccountSelector = "#block-collapsible-nav > ul > li.nav.item.current > strong"; //css
     private String myOrdersSelector = "//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a"; //xpath
     private String myProductsSelector = "#block-collapsible-nav > ul > li:nth-child(3) > a"; //css
     private String myAddressesSelector = "#block-collapsible-nav > ul > li:nth-child(5) > a"; //css
     private String confidentialitySelector = "#block-collapsible-nav > ul > li:nth-child(6) > a";
     private String paymentsMethodSelector = "#block-collapsible-nav > ul > li:nth-child(7) > a";
     private String myReviewsSelector = "#block-collapsible-nav > ul > li:nth-child(9) > a";
     private String mySubscriptionSelector = "#block-collapsible-nav > ul > li:nth-child(10) > a";
     private String mySocialAccountsSelector = "#block-collapsible-nav > ul > li:nth-child(11) > a";

     public AccountOptionsPage(WebDriver driver) {
          super(driver);
     }
     public void verifyPage(){
          Assert.assertEquals(driver.findElement(By.cssSelector(myAccountSelector)).getText(), "Contul meu");
          Assert.assertEquals(driver.findElement(By.xpath(myOrdersSelector)).getText(), "Comenzile mele");
          Assert.assertEquals(driver.findElement(By.cssSelector(myProductsSelector)).getText(), "Produsele mele descărcabile");
          Assert.assertEquals(driver.findElement(By.cssSelector(myAddressesSelector)).getText(), "Adrese");
          Assert.assertEquals(driver.findElement(By.cssSelector(confidentialitySelector)).getText(), "Setările de confidențialitate");
          Assert.assertEquals(driver.findElement(By.cssSelector(paymentsMethodSelector)).getText(), "Metode de plata salvate");
          Assert.assertEquals(driver.findElement(By.cssSelector(myReviewsSelector)).getText(), "Recenziile mele");
          Assert.assertEquals(driver.findElement(By.cssSelector(mySubscriptionSelector)).getText(), "Abonari la newsletter");
          Assert.assertEquals(driver.findElement(By.cssSelector(mySocialAccountsSelector)).getText(), "Conturi sociale asociate");
     }
}
