package Tests.DataTests;

import Pages.AccountOptionsPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
     @Test
     public void loginTest(){
          driver.get(baseUrl + "/customer/account/login/");
          LoginPage lp = new LoginPage(driver);
          lp.verifyPage();
          lp.login("tested@hotmail.com", "Parola4321");

          AccountOptionsPage acp = new AccountOptionsPage(driver);
          acp.verifyPage();
     }
}
