package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

public class BrowserUtils {


     public static WebDriver getBrowser(String browser){  //browser factory classic method
          switch (browser.toLowerCase()) {
               case ("chrome") -> {
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
               }
               case ("firefox") -> {
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
               }
               case ("edge") -> {
                    WebDriverManager.edgedriver().setup();
                    return new EdgeDriver();
               }
               default -> {
                    System.out.println("Driver is not supported officially, please be careful");
                    return WebDriverManager.getInstance(browser).getWebDriver();
               }
          }
     }

     public static Browser getBrowser(BrowserTypes browserType) { //second method browser factory
          switch(browserType.toString()) {
               case ("CHROME") : {
                    return new ChromeBrowser();
               }
               case("FIREFOX") : {
                    return new FirefoxBrowser();
               }
               case("EDGE") : {
                    return new EdgeBrowser();
               }
               default : {
                    System.out.println("Browser not supported");
                    return null;
               }
          }
     }

     public static String getBrowserExternal(String propertyName) { //get browser from env variables (exterior)
          // Take all the system environment names and values
          Map<String, String> env = System.getenv();
          // Check if the property is set
          if (env.containsKey(propertyName)) {
               System.out.println("Running from ENV variable with browser: " + System.getenv(propertyName));
               return System.getenv(propertyName).toLowerCase();
          }
          else {
               return "CHROME";
          }
     }
}
