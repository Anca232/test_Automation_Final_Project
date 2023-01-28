package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {

     private String existingClientSelector = "#block-customer-login-heading"; //css
     private String emailInputSelector = "#email"; //css
     private String passwordInputSelector = "#pass"; //css
     private String forgetPasswordSelector = "#login-form > fieldset > div.actions-toolbar > div.secondary > a > span"; //css
     private String submitButtonSelector = "#send2 > span"; //css

     public LoginPage(WebDriver driver) {
          super(driver);
     }

     public void verifyPage(){
          Assert.assertEquals(driver.findElement(By.cssSelector(existingClientSelector)).getText(), "Client existent");
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
}
