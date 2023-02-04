package Tests.DataTests;

import Utils.SeleniumUtils;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

public class CookieTest extends BaseTest {

     @Test
     public void cookieTest(){
          driver.get(baseUrl);
          SeleniumUtils.printCookies(driver);
          SeleniumUtils.takeScreenshot(driver);
     }

     @Test
     public void addCookieTest(){
          driver.get(baseUrl);
          Set<Cookie> cookies = driver.manage().getCookies();
          System.out.println(cookies.size());
          Cookie c1 = new Cookie("new_cookie", "this is the new cookie value");

          driver.manage().addCookie(c1);
          System.out.println(driver.manage().getCookies().size());
          System.out.println("Is cookie present? " + SeleniumUtils.checkIfCookieExistsByName(driver, "new_cookie"));

          driver.manage().deleteCookieNamed("new_cookie");
          System.out.println(driver.manage().getCookies().size());
          System.out.println("Is cookie present? " + SeleniumUtils.checkIfCookieExistsByName(driver, "new_cookie"));
     }
}
