package Pages;

import Tests.ObjectModels.MyAccountModel;
import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.util.List;

public class LoginPage extends BasePage {
     WebDriverWait wait;
     static WebDriver driver;
     private MyAccountModel account;

     private String titlePageSelector = "#maincontent > div.columns > div > div.sociallogin-wrapper.block-customer-login > div > div.block-title > h3";
     private String emailInputSelector = "#email"; //css
     private String passwordInputSelector = "#pass"; //css
     private String forgetPasswordSelector = "#login-form > fieldset > div.actions-toolbar > div.secondary > a > span"; //css
     private String submitButtonSelector = "#send2 > span"; //css
     private static String emailError = "//*[@id=\"email-error\"]";
     private static String passwordError = "//*[@id=\"pass-error\"]";
     private String byClassName = "input-text";
//     private static Label emailErr;
//     private static Label passwordErr;


     public LoginPage(WebDriver driver) {
          LoginPage.driver = driver;
          wait = new WebDriverWait(driver, 10);
          PageFactory.initElements(driver, this);
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
          driver.findElement(By.cssSelector(submitButtonSelector)).click();

          WebElement emailErr = SeleniumUtils.waitForGenericElement(driver, By.xpath(emailError), 10);
          Actions actions = new Actions(driver);
          actions.moveToElement(emailErr).build().perform();
          Assert.assertEquals(emailErr.getText(),"Acesta este un camp obligatoriu.");
          System.out.println(emailErr.isDisplayed());

          WebElement passwordErr = SeleniumUtils.waitForGenericElement(driver, By.xpath(passwordError), 10);
          Assert.assertEquals(passwordErr.getText(), "Acesta este un camp obligatoriu.");
          actions.moveToElement(passwordErr).build().perform();
          System.out.println(passwordErr.isDisplayed());
     }

     public static boolean checkErr(String expectedErr, String errorType) {
          WebElement emailErr = SeleniumUtils.waitForGenericElement(driver, By.xpath(emailError), 10);
          Assert.assertEquals(emailErr.getText(),"Acesta este un camp obligatoriu.");

          WebElement passwordErr = SeleniumUtils.waitForGenericElement(driver, By.xpath(passwordError), 10);
          Assert.assertEquals(passwordErr.getText(), "Acesta este un camp obligatoriu.");

          if (errorType.equalsIgnoreCase("userErr")) {
               if (expectedErr.length() > 0) {
                    System.out.println("Actual user error:" + emailErr.getText());
                    return expectedErr.equals(emailErr.getText());
               } else return true;
          } else if (errorType.equalsIgnoreCase("passErr")) {
               if (expectedErr.length() > 0) {
                    System.out.println("Actual pass error:" + passwordErr.getText());
                    return expectedErr.equalsIgnoreCase(passwordErr.getText());
               } else return true;
          }
          return true;
     }
}
