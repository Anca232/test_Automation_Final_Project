package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class ChromeDriver extends Browser {

     public void ChromeBrowser() {
          WebDriverManager.chromedriver().setup();
          this.driver = (WebDriver) new ChromeDriver();
     }


}
