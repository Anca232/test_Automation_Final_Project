package Pages;

import Tests.ObjectModels.MyAccountModel;
import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

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
     private String byClassName = "input-text";


     public LoginPage(WebDriver driver) {
          super(driver);
     }

     public void verifyPage(){
          List<WebElement> elements = driver.findElements(By.className(byClassName));
          System.out.println(elements.size());
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

     public void getLoginError() {
          WebElement submitButtonInput = driver.findElement(By.cssSelector(submitButtonSelector));
          submitButtonInput.submit();
//          WebDriverWait wait = new WebDriverWait(driver, 10);

          WebElement emailErr = SeleniumUtils.waitForGenericElement(driver, By.xpath(emailError), 10);
          Assert.assertEquals(emailErr.getText(),"Acesta este un camp obligatoriu.");
          System.out.println(emailErr.isDisplayed());

          WebElement passwordErr = SeleniumUtils.waitForGenericElement(driver, By.xpath(passwordError), 10);
          Assert.assertEquals(passwordErr.getText(), "Acesta este un camp obligatoriu.");
          System.out.println(passwordErr.isDisplayed());

     }
//     public String getPasswordError() {
//          driver.findElement(By.cssSelector(submitButtonSelector)).submit();
//          WebElement emailErr = SeleniumUtils.waitForGenericElement(driver, By.xpath(emailError), 10);
//          return driver.findElement(By.xpath(String.valueOf(emailErr))).getText();
//     }

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
