package Tests;

import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

     @Test
     public void loginBasic(){
          driver.get("https://www.magazialucostica.ro/customer/account/login/");
          LoginPage lp =new LoginPage(driver);
          lp.verifyPage();
          lp.login("test2@yahoo.com", "gsrYbWyvui.6dmX");
     }


}
