package Tests.DataTests;

import Pages.LoginPage;
import Pages.MyAccountPage;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {

     @Test
     public void myAccountTest(){
          driver.get(baseUrl + "/customer/account/");
          LoginPage lp = new LoginPage(driver);
          lp.login("tibi.pop@gmail.com", "Pass1234!");
          MyAccountPage map = new MyAccountPage(driver);
          map.changePass();
     }
}
