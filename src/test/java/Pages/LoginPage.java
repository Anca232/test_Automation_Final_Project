package Pages;

import Tests.ObjectModels.MyAccountModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.xml.bind.annotation.XmlElement;

public class LoginPage extends BasePage {


     WebDriverWait wait;
     private MyAccountModel account;

     private String titlePageSelector = "#maincontent > div.columns > div > div.sociallogin-wrapper.block-customer-login > div > div.block-title > h3";
     private String emailInputSelector = "#email"; //css
     private String passwordInputSelector = "#pass"; //css
     private String forgetPasswordSelector = "#login-form > fieldset > div.actions-toolbar > div.secondary > a > span"; //css
     private String submitButtonSelector = "#send2 > span"; //css
     private String emailError = "//*[@id=\"email-error\"]";
     private String passwordError = "//*[@id=\"pass-error\"]";


     public LoginPage(WebDriver driver) {
          super(driver);
     }

     public void verifyPage(){
          Assert.assertEquals(driver.findElement(By.cssSelector(titlePageSelector)).getText(), "Intra in cont");
          Assert.assertEquals(driver.findElement(By.cssSelector(forgetPasswordSelector)).getText(), "Ti-ai uitat parola?");
     }

     public void login(String email, String password){
          WebElement emailInput = driver.findElement(By.cssSelector(emailInputSelector));
          WebElement passwordInput = driver.findElement(By.cssSelector(passwordInputSelector));
          WebElement submitButtonInput = driver.findElement(By.cssSelector(submitButtonSelector));

          emailInput.clear();
          emailInput.sendKeys(email);
          passwordInput.clear();
          passwordInput.sendKeys(password);
          submitButtonInput.submit();
     }

     public String getUsernameError() {
          driver.findElement(By.cssSelector(submitButtonSelector)).click();
          return driver.findElement(By.xpath(emailError)).getAttribute("innerHTML");
     }
     public String getPasswordError() {
          driver.findElement(By.cssSelector(submitButtonSelector)).click();
          return driver.findElement(By.xpath(passwordError)).getAttribute("innerHTML");
     }

//     @Override
//     public String toString() {
//          return "LoginModel{" +
//                  "account=" + account +
//                  '}';
//     }

//     public void clickOnAlertButton(){
//          WebElement cookieButton = driver.findElement(By.cssSelector(alertButtonSelector));
//          cookieButton.click();
//     }

//     public String getEmailError(){
//          return driver.findElement(By.id(emailError)).getText();
//     }
}
