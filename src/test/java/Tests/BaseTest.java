package Tests;

import Utils.BrowserTypes;
import Utils.BrowserUtils;
import Utils.GenericUtils;
import com.google.common.io.Resources;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

     WebDriver driver;

     String browser = BrowserUtils.getBrowserExternal("automationBrowser");
     String baseUrl = GenericUtils.createBaseUrl("src\\test\\java\\Resources\\config.properties");

     @BeforeTest
     public void beforeTest() {
          System.out.println(baseUrl);
          driver = BrowserUtils.getBrowser(browser);
//          driver = BrowserUtils.getBrowser(BrowserTypes.CHROME).getDriver();
     }
     @AfterTest
     public void afterTest() {
          driver.quit();
     }
}
