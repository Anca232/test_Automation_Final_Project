package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtils {

     public static WebDriver getBrowser(String browser){
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


}
