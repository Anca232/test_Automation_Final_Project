package Tests.DataTests;

import Pages.RegistrationPage;
import Utils.GenericUtils;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

     @Test
     public void registrationWithRandomCharactersTest(){
          driver.get(baseUrl + "/customer/account/create/");
          RegistrationPage lp =new RegistrationPage(driver);
          lp.verifyRegistrationPage();
          lp.registration(GenericUtils.createRandomString(10),
                  GenericUtils.createRandomString(10),
                  GenericUtils.createRandomString(10),
                  GenericUtils.createRandomString(10),
                  GenericUtils.createRandomString(10));
     }
     @Test
     public void registrationWithPredefinedNameTest(){
          driver.get(baseUrl + "/customer/account/create/");
          RegistrationPage rp =new RegistrationPage(driver);
          rp.registration("MaryM", "Poppy", "marymaePoppy@yahoo.com", "Password321", "Password123");
     }
}
