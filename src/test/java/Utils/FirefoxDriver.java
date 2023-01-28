package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class FirefoxDriver extends Browser {

     public void FirefoxBrowser() {
          WebDriverManager.firefoxdriver().setup();
          this.driver = (WebDriver) new FirefoxDriver();
     }
}
