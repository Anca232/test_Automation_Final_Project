package Tests;

import Utils.BrowserUtils;
import Utils.ConstantUtils;
import Utils.GenericUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

     WebDriver driver;
     //String browser = BrowserUtils.getBrowserExternal("automationBrowser");
     String browser = GenericUtils.getBrowserConfig(ConstantUtils.CONFIG_FILE);
     String baseUrl = GenericUtils.createBaseUrl(ConstantUtils.CONFIG_FILE);

     @BeforeTest
     public void beforeTest() {
          System.out.println(baseUrl);
          driver = BrowserUtils.getBrowser(browser, ConstantUtils.CONFIG_FILE);
     //     driver = BrowserUtils.getBrowser(BrowserTypes.CHROME).getDriver();
     }
     @AfterTest
     public void afterTest() {
          driver.quit();
     }
}
