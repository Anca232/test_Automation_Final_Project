package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class ChromeBrowser extends Browser {

     public ChromeBrowser() {
          WebDriverManager.chromedriver().setup();
          this.driver = (WebDriver) new ChromeBrowser();
     }


}
