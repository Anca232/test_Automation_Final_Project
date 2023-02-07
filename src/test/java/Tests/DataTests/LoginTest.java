package Tests.DataTests;

import Pages.AccountOptionsPage;
import Pages.LoginPage;
import Utils.GenericUtils;
import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {
     @Test
     public void loginTest() {
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.get(baseUrl + "/customer/account/login/");
          driver.manage().deleteAllCookies();
          LoginPage lp = new LoginPage(driver);
          lp.verifyPage();
          lp.login("tested@hotmail.com", "Parola4321");
          AccountOptionsPage acp = new AccountOptionsPage(driver);
          acp.verifyPage();
     }

     @Test
     public void getAccountErrorsTest() {
          driver.get(baseUrl + "/customer/account/login/");
          LoginPage lp = new LoginPage(driver);
          lp.getLoginError();
     }

}
