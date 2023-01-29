package IgnoreThemPracticeTests;

import Utils.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import java.util.List;

public class SeleniumTest extends BaseTest {

     WebDriver driver;
     String browser = "chrome";

//     @BeforeTest
//     public void beforeTest() {
//          if (browser.toLowerCase().equals("chrome")) {
//               WebDriverManager.chromedriver().setup();
//               driver = new ChromeDriver();
//          }
//          if (browser.toLowerCase().equals("firefox")) {
//               WebDriverManager.firefoxdriver().setup();
//               driver = new FirefoxDriver();
//          }
//          if (browser.toLowerCase().equals("edge")) {
//               WebDriverManager.edgedriver().setup();
//               driver = new EdgeDriver();
//          }
//     }

     @Test
     public void mySecondSeleniumTest(){
          driver.get("https://www.magazialucostica.ro/");
          List<WebElement> elements = driver.findElements(By.className("menu__link"));
          System.out.println(elements.size());
          Assert.assertEquals(elements.get(0).getText(), "Tractoare");

//          System.out.println(SeleniumUtils.createRandomString(20));
//          WebElement myAccount = driver.findElement(By.cssSelector("//*[@id=\"html-body\"]/div[2]/header/div[2]/ul/div/ul/li[1]/a"));
//          myAccount.click();
     }
     @DataProvider(name = "basicTest")
     public Iterator<Object[]> basicTestDataProvider(){
          Collection<Object[]> dp = new ArrayList<>();
          dp.add(new String[] {"", "", "Acesta este un camp obligatoriu.", "Acesta este un camp obligatoriu."});
//          dp.add(new String[] {"test@gmail.com", "Test1", ""});
          return dp.iterator();
     }

     @Test(dataProvider = "basicTest")
     public void basicTest(String email, String password, String emailErr, String passErr){
          driver.get("https://www.magazialucostica.ro/customer/account/login/");
          WebElement pageText = driver.findElement(By.cssSelector("#maincontent > div.columns > div > div.sociallogin-wrapper.block-customer-login > div > div.block-title > h3"));
          Assert.assertEquals(pageText.getText(), "Intra in cont");

//          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//          WebElement emailInput = driver.findElement(By.id("email"));
//          WebElement passwordInput = driver.findElement(By.id("pass"));

//          emailInput.clear();
//          emailInput.sendKeys(email);
//          passwordInput.clear();
//          passwordInput.sendKeys(password);

//          WebDriverWait wait = new WebDriverWait(driver, 10);
          WebElement loginButton = driver.findElement(By.cssSelector("#send2"));
          loginButton.click();

          WebElement emailError = driver.findElement(By.cssSelector("#email-error"));
          WebElement passwordError = driver.findElement(By.cssSelector("#pass-error"));

//          WebDriverWait wait2 = new WebDriverWait(driver, 10);
//          WebElement errorMsg = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("email-error")));
//          errorMsg.click();
//          BrowserUtilities.waitForTextOnSite(driver, By.cssSelector("#email-error"));
//          emailError.click();
          Assert.assertEquals(emailError.getText(), emailErr);
          Assert.assertEquals(passwordError.getText(), passErr);
     }

//     @Test
//     public void waitExplicitTest(){
//          driver.navigate().to("https://www.magazialucostica.ro/customer/account/login/");
//          WebDriverWait wait = new WebDriverWait(driver, 10);
//          WebElement errorMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email-error")));
//          errorMsg.click();
////          WebElement errorMsg = driver.findElement(By.id("email-error"));
//     }

//     @AfterTest
//     public void afterTest(){
//          driver.quit();
//     }
}
