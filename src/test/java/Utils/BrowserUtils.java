package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class BrowserUtils {


     public static WebDriver getBrowser(String browser, String configFile){  //browser factory classic method
          switch (browser.toLowerCase()) {
               case ("chrome") -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setAcceptInsecureCerts(GenericUtils.getInsecureCertOptions(ConstantUtils.CONFIG_FILE));
                    options.setHeadless(GenericUtils.getHeadlessMode(ConstantUtils.CONFIG_FILE));

                    if(GenericUtils.isProxyEnabled(ConstantUtils.CONFIG_FILE)) {
                         Proxy proxy = new Proxy();
                         proxy.setHttpProxy(
                                 ConfigUtils.getGenericValue(ConstantUtils.CONFIG_FILE,"proxyAddress", "127.0.0.1") + ":" +
                                         ConfigUtils.getGenericValue(ConstantUtils.CONFIG_FILE, "proxyPort", "8081"));
                         options.setProxy(proxy);
                    }

                    // Setting a fixed download directory
                    if(GenericUtils.isDownloadDirectoryEnabled(ConstantUtils.CONFIG_FILE)) {
                         Map<String, Object> preferences = new HashMap<>();
                         preferences.put("download.default_directory", ConstantUtils.DOWNLOAD_DIRECTORY);
                         options.setExperimentalOption("prefs", preferences);
                    }

                    if(GenericUtils.startMaximized(ConstantUtils.CONFIG_FILE)) {
                         // Start the browser maximized
                         options.addArguments("--start-maximized");
                    }

                    return new ChromeDriver(options);
               }
               case ("firefox") -> {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    FirefoxProfile profile = new FirefoxProfile();
                    if(GenericUtils.startMaximized(configFile)) {
                         options.addArguments("--start-maximized");
                    }

                    if(GenericUtils.isDownloadDirectoryEnabled(configFile)) {
                         profile.setPreference("browser.download.dir", ConstantUtils.DOWNLOAD_DIRECTORY);
                    }

                    options.setHeadless(GenericUtils.getHeadlessMode(configFile));
                    options.setAcceptInsecureCerts(GenericUtils.getInsecureCertOptions(configFile));

                    options.setProfile(profile);
                    WebDriver driver = new FirefoxDriver(options);

                    if(GenericUtils.startMaximized(configFile)) {
                         driver.manage().window().maximize();
                    }
                    driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigUtils.getGenericValue(configFile, "implicitTimeout", "10")), TimeUnit.SECONDS);
                    return driver;
               }
               case ("edge") -> {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options = new EdgeOptions();

                    return new EdgeDriver(options);
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
               return "EDGE";
          }
     }
}
