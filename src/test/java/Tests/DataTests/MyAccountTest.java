package Tests.DataTests;

import Pages.LoginPage;
import Pages.MyAccountPage;
import Utils.ExtentTestManager;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class MyAccountTest extends BaseTest {

     @Test(groups = {"Regression"})
     public void myAccountTest(Method method){
          ExtentTestManager.startTest(method.getName(), "");
          driver.get(baseUrl + "/customer/account/");
          LoginPage lp = new LoginPage(driver);
          lp.verifyPage();
          lp.login("tibi.pop@gmail.com", "Pass1234!");


          MyAccountPage map = new MyAccountPage(driver);
          map.changePass();
     }
}
