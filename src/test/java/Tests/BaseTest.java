package Tests;

import Utils.BrowserTypes;
import Utils.BrowserUtils;
import Utils.GenericUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

     WebDriver driver;
     String browser = "chrome";

     String baseUrl = GenericUtils.createBaseUrl("\\src\\test\\java\\Resources\\config.properties");

     @BeforeMethod
     public void beforeTest() {
          System.out.println(baseUrl);
          driver = BrowserUtils.getBrowser(browser);
     }

     @AfterMethod
     public void afterTest() {
          driver.quit();
     }
}
