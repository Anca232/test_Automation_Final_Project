package IgnoreThemPracticeTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

     public WebDriver driver;
     String browser = "chrome";

     @BeforeTest
     public void beforeTest() {
          if (browser.toLowerCase().equals("chrome")) {
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
          }
          if (browser.toLowerCase().equals("firefox")) {
               WebDriverManager.firefoxdriver().setup();
               driver = new FirefoxDriver();
          }
          if (browser.toLowerCase().equals("edge")) {
               WebDriverManager.edgedriver().setup();
               driver = new EdgeDriver();
          }

          //          System.out.println(baseUrl);
//          driver = BrowserUtils.getBrowser(browser, ConstantUtils.CONFIG_FILE);
//     //     driver = BrowserUtils.getBrowser(BrowserTypes.CHROME).getDriver();
//     }
     }

     @AfterTest
     public void afterTest(){
          driver.quit();
     }
}
