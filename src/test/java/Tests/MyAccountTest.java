package Tests;

import Pages.LoginPage;
import Pages.MyAccountPage;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {

     @Test
     public void myAccountTest(){
          driver.get(baseUrl + "/customer/account/");
          LoginPage lp = new LoginPage(driver);
          lp.verifyPage();
          lp.login("testing@gmail.com", "Testing1234");
          MyAccountPage map = new MyAccountPage(driver);
          map.verifyPage();

     }

}
