package Tests;

import Pages.AccountOptionsPage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

     @Test
     public void loginBasic(){
          driver.get(baseUrl + "/customer/account/login/");
          LoginPage lp = new LoginPage(driver);
          lp.verifyPage();
          lp.login("sara_p@gmail.com", "Password2023");

//          Assert.assertEquals(lp.getEmailError(),emailErr);
//          AccountOptionsPage aop = new AccountOptionsPage(driver);
//          aop.verifyPage();
//          SeleniumUtils.takeScreenshot(driver);
     }

//     @Test
//     public void accountOptions(){
//     }
//     @Test
//     public void loginPositiveTest(){
//          driver.get("https://www.magazialucostica.ro/customer/account/login/");
//          LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
//          lp.login("abca", "password");
//     }
}
