package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class RegistrationPage extends BasePage {

     private String pageTitleSelector = "//*[@id=\"maincontent\"]/div[3]/div/div[1]/div/div[1]/h3"; //xpath
     private String firstNameInputSelector = "firstname"; //id
     private String lastNameInputSelector = "lastname"; //id
     private String emailAddressInputSelector = "email_address"; //id
     private String passwordInputSelector = "password";
     private String confirmPasswordSelector = "password-confirmation";
     private String policySelector = "#amprivacy-checkbox > label > a"; //css
     private String policyCLickSelector = "#amgdpr_agree"; //css
     private String submitAccountButton = "#form-validate > div > div.primary > button > span"; //css

     public RegistrationPage(WebDriver driver) {
          super(driver);
     }

     public void verifyRegistrationPage(){
          Assert.assertEquals(driver.findElement(By.xpath(pageTitleSelector)).getText(), "Intra in cont");
          Assert.assertEquals(driver.findElement(By.cssSelector(policySelector)).getText(),
                  "politica de confidentialitate MagaziaLuCostica.ro");
     }

     public void registration(String firstName, String lastName, String email, String password, String confirmPassword){
          WebElement firstNameInput = driver.findElement(By.id(firstNameInputSelector));
          WebElement lastNameInput = driver.findElement(By.id(lastNameInputSelector));
          WebElement emailAddressInput = driver.findElement(By.id(emailAddressInputSelector));
          WebElement passwordInput = driver.findElement(By.id(passwordInputSelector));
          WebElement confirmPasswordInput = driver.findElement(By.id(confirmPasswordSelector));
          WebElement policyClickBox = driver.findElement(By.cssSelector(policyCLickSelector));
          WebElement submitAccountInput = driver.findElement(By.cssSelector(submitAccountButton));

          firstNameInput.clear();
          firstNameInput.sendKeys(firstName);
          lastNameInput.clear();
          lastNameInput.sendKeys(lastName);
          emailAddressInput.clear();
          emailAddressInput.sendKeys(email);
          passwordInput.clear();
          passwordInput.sendKeys(password);
          confirmPasswordInput.clear();
          confirmPasswordInput.sendKeys(confirmPassword);

          Actions actions = new Actions(driver);
          actions.moveToElement(policyClickBox).click().build().perform();

          submitAccountInput.submit();


     }
}
