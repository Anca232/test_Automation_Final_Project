package Tests.DataTests;

import Utils.BrowserUtils;
import Utils.ConstantUtils;
import Utils.GenericUtils;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class BaseTest {

     public WebDriver driver;
     String usedConfig = ConstantUtils.CONFIG_FILE;
     String dbHostname, dbUser, dbSchema, dbPassword, dbPort;
     //String browser = BrowserUtils.getBrowserExternal("automationBrowser");
     String browser = GenericUtils.getBrowserConfig(usedConfig);
     String baseUrl = GenericUtils.createBaseUrl(ConstantUtils.CONFIG_FILE);

     ExtentTest test;
//     Base64 base64 = new Base64();


     @BeforeTest(alwaysRun = true)
     public void beforeTest() {
          setUpDriver();
     }
     @BeforeClass
     public void beforeClass(){
          if(driver == null){
               setUpDriver();
          }
     }
     @AfterTest(alwaysRun = true)
     public void afterTest() {
          driver.quit();

     }
     @AfterClass
     public void quitDriver(){
          if(driver != null) {
               driver.quit();
          }
     }
     public void setUpDriver(){
          System.out.println("Base URL:" + baseUrl);
          driver = BrowserUtils.getBrowser(browser, usedConfig);
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          dbHostname = GenericUtils.getDBHostname(usedConfig);
          dbUser = GenericUtils.getDBUser(usedConfig);
          dbPassword = GenericUtils.getDBPassword(usedConfig);
          dbPort = GenericUtils.getDBPort(usedConfig);
          dbSchema = GenericUtils.getDBSchema(usedConfig);
     }
}
