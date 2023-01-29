package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class FirefoxBrowser extends Browser {

     public FirefoxBrowser() {
          WebDriverManager.firefoxdriver().setup();
          this.driver = (WebDriver) new FirefoxBrowser();
     }
}
