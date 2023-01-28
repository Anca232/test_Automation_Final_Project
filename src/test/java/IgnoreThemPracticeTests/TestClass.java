package IgnoreThemPracticeTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class TestClass {
     WebDriver driver;
     String browser = "chrome";

     @BeforeTest
     public void beforeTest() {
          if (browser.toLowerCase().equals("chrome")) {
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
          }
     }

     @Test
     public void waitTest() {
          driver.navigate().to("https://www.magazialucostica.ro/customer/account/login/");
          WebElement loginButton = driver.findElement(By.cssSelector("#send2"));
          loginButton.click();
          WebElement errorMsg = driver.findElement(By.id("email-error"));
          System.out.println(loginButton.isDisplayed());
          System.out.println(loginButton.isSelected());
          System.out.println(loginButton.isEnabled());
          System.out.println(loginButton.getAttribute("email-error"));
          System.out.println(loginButton.getTagName());

     }

     @DataProvider(name = "basicTest")
     public Iterator<Object[]> basicTestDataProvider(){
          Collection<Object[]> dp = new ArrayList<>();
          dp.add(new String[] {"", "", "Acesta este un camp obligatoriu.", "Acesta este un camp obligatoriu."});
//          dp.add(new String[] {"test@gmail.com", "Test1"});
          return dp.iterator();
     }

     @Test(dataProvider = "basicTest")
     public void insertData(String email, String password, String emailErr, String passErr){
          driver.navigate().to("https://www.magazialucostica.ro/customer/account/login/");
          WebElement emailInput = driver.findElement(By.id("email"));
          WebElement passwordInput = driver.findElement(By.id("pass"));

          emailInput.clear();
          emailInput.sendKeys(email);
          passwordInput.clear();
          passwordInput.sendKeys(password);
     }

     @AfterTest
     public void afterTest(){
          driver.quit();
     }
}
