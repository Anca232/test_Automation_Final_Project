package Tests.DataTests;

import Utils.BrowserUtils;
import Utils.ConstantUtils;
import Utils.GenericUtils;
//import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Base64;

public class BaseTest {

     public WebDriver driver;
     String usedConfig = ConstantUtils.CONFIG_FILE;
     String dbHostname, dbUser, dbSchema, dbPassword, dbPort;
     String browser;
     String baseUrl = GenericUtils.createBaseUrl(usedConfig);
//     Base64 base64 = new Base64();
//     ExtentTest test;

     @BeforeTest
     public void beforeTest() {
          System.out.println(baseUrl);
          browser = System.getProperty("browser");
          if (browser == null)
               //default value
               browser = GenericUtils.getBrowserConfig(usedConfig);

          System.out.println("Used browser:" + browser);

          driver = BrowserUtils.getBrowser(browser, usedConfig);
          dbHostname = GenericUtils.getDBHostname(usedConfig);
          dbUser = GenericUtils.getDBUser(usedConfig);
          dbPassword = GenericUtils.getDBPassword(usedConfig);
          dbPort = GenericUtils.getDBPort(usedConfig);
          dbSchema = GenericUtils.getDBSchema(usedConfig);
     }

//     @AfterMethod
//     public void getResult(ITestResult result) {
//          test = ExtentTestManager.updateTest(test, driver, result);
//     }

     @AfterTest
     public void afterTest() {
          driver.quit();
//          ExtentTestManager.extent.flush();
     }

}
