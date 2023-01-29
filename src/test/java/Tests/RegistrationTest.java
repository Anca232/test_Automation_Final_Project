package Tests;

import Pages.RegistrationPage;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

     @Test
     public void registrationBasic(){
          driver.get(baseUrl + "/customer/account/create/");
          RegistrationPage lp =new RegistrationPage(driver);
          lp.verifyRegistrationPage();
          lp.registration("Mary", "Winch", "marywinch23@yahoo.com", "Password123", "Password123");
     }
}
