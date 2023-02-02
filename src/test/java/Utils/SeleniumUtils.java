package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Set;
import java.util.regex.Pattern;

public class SeleniumUtils {

     public static WebElement waitForGenericElement(WebDriver driver, By locator, int timeout) {
          WebDriverWait wait = new WebDriverWait(driver, timeout);
          return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
     }

     public static Boolean waitForTextOnSite(WebDriver driver, By locator, int timeout, String pattern) {
          WebDriverWait wait = new WebDriverWait(driver, timeout);
          Pattern patt = Pattern.compile(pattern);
          return wait.until(ExpectedConditions.textMatches(locator, patt));
     }

     public static void printCookies(WebDriver driver) {
          Set<Cookie> cookies = driver.manage().getCookies();
          System.out.println("Number of cookies found: " + cookies.size());
          for (Cookie c : cookies) {
               System.out.println("Cookie name: " + c.getName());
               System.out.println("--> Cookie value : " + c.getValue());
               System.out.println("--> Cookie domain: " + c.getDomain());
               System.out.println("--> Cookie expiration date: " + c.getExpiry());
               System.out.println("--> Cookie path: " + c.getPath());
          }
     }

     public static boolean checkIfCookieExistsByName(WebDriver driver, String cookieName) {
          Set<Cookie> cookies = driver.manage().getCookies();
          for (Cookie c : cookies) {
               if (c.getName().equalsIgnoreCase(cookieName)) {
                    return true;
               }
          }
          return false;
     }
     public static void takeScreenshot(WebDriver driver) {
          Timestamp timestamp = new Timestamp(System.currentTimeMillis());
          System.out.println(timestamp.getTime());
          File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//          String filename = ConstantUtils.SCREENSHOT_FOLDER + "screenshot_" + timestamp.getTime() +  ".png";
          try {
               FileUtils.copyFile(screenshotFile,
                       new File(ConstantUtils.SCREENSHOT_FOLDER + "screenshot_" + timestamp.getTime() + ".png"));
          } catch (IOException e) {
               System.out.println("File could not be saved on the disk!!");
          }
     }
}

