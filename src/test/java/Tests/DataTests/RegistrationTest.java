package Tests.DataTests;

import Pages.RegistrationPage;
import Utils.ExtentTestManager;
import Utils.GenericUtils;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class RegistrationTest extends BaseTest {

     @Test(groups = {"Regression"})
     public void registrationWithRandomCharactersTest(Method method){
          ExtentTestManager.startTest(method.getName(), "");
          driver.get(baseUrl + "/customer/account/create/");
          RegistrationPage lp =new RegistrationPage(driver);
          lp.verifyRegistrationPage();
          lp.registration(GenericUtils.createRandomString(10),
                  GenericUtils.createRandomString(10),
                  GenericUtils.createRandomString(10),
                  GenericUtils.createRandomString(10),
                  GenericUtils.createRandomString(10));
     }
     @Test(groups = {"Regression"})
     public void registrationWithPredefinedValuesTest(Method method){
          ExtentTestManager.startTest(method.getName(), "");
          driver.get(baseUrl + "/customer/account/create/");
          RegistrationPage rp =new RegistrationPage(driver);
          rp.registration("MaryM", "Poppy", "marymaePoppy@yahoo.com", "Password321", "Password123");
     }
}
