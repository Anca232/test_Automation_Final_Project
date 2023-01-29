package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccountPage extends BasePage {
     private String myAccountSelector = "//*[@id=\"maincontent\"]/div[3]/div[2]/div[1]/h1/span"; //xpath
     private String infoAccountSelector = "//*[@id=\"maincontent\"]/div[3]/div[2]/div[3]/div[1]/strong";
     private String infoContactSelector = "//*[@id=\"maincontent\"]/div[3]/div[2]/div[3]/div[2]/div[1]/strong/span";
     private String changePasswordSelector = "#maincontent > div.columns > div.column.main > div.block.block-dashboard-info > div.block-content > div.box.box-information > div.box-actions > a.action.change-password"; //css
     private String addressesSelector = "//*[@id=\"maincontent\"]/div[3]/div[2]/div[4]/div[1]/strong";
     private String addressesAdminSelector = "#maincontent > div.columns > div.column.main > div.block.block-dashboard-addresses > div.block-title > a"; //css
     private String invoiceAddressSelector = "//*[@id=\"maincontent\"]/div[3]/div[2]/div[4]/div[2]/div[1]/strong/span";
     private String editAddressSelector = "#maincontent > div.columns > div.column.main > div.block.block-dashboard-addresses > div.block-content > div.box.box-billing-address > div.box-actions > a"; //css
     private String newsletterSelector = "//*[@id=\"maincontent\"]/div[3]/div[2]/div[3]/div[2]/div[2]/strong/span";
     private String editNewsletterSelector = "#maincontent > div.columns > div.column.main > div.block.block-dashboard-info > div.block-content > div.box.box-newsletter > div.box-actions > a";
     private String deliveryAddressSelector = "//*[@id=\"maincontent\"]/div[3]/div[2]/div[4]/div[2]/div[2]/strong/span";
     private String editDeliveryAddressSelector = "#maincontent > div.columns > div.column.main > div.block.block-dashboard-addresses > div.block-content > div.box.box-shipping-address > div.box-actions > a";

     public MyAccountPage(WebDriver driver) {
          super(driver);
     }

     public void verifyPage(){
          Assert.assertEquals(driver.findElement(By.xpath(myAccountSelector)).getText(), "Contul meu");
          Assert.assertEquals(driver.findElement(By.xpath(infoAccountSelector)).getText(), "Informatii cont");
          Assert.assertEquals(driver.findElement(By.xpath(infoContactSelector)).getText(), "Informatii contact");
          Assert.assertEquals(driver.findElement(By.cssSelector(changePasswordSelector)).getText(), "Schimba parola");
          Assert.assertEquals(driver.findElement(By.xpath(addressesSelector)).getText(), "Adrese");
          Assert.assertEquals(driver.findElement(By.cssSelector(addressesAdminSelector)).getText(), "Administreaza adrese");
          Assert.assertEquals(driver.findElement(By.xpath(invoiceAddressSelector)).getText(), "Adresa de facturare implicita");
          Assert.assertEquals(driver.findElement(By.cssSelector(editAddressSelector)).getText(), "Editeaza adresa");
          Assert.assertEquals(driver.findElement(By.xpath(newsletterSelector)).getText(), "Newsletters");
          Assert.assertEquals(driver.findElement(By.cssSelector(editNewsletterSelector)).getText(), "Editeaza");
          Assert.assertEquals(driver.findElement(By.xpath(deliveryAddressSelector)).getText(), "Adresa de livrare");
          Assert.assertEquals(driver.findElement(By.cssSelector(editDeliveryAddressSelector)).getText(), "Editeaza adresa");
     }
}

