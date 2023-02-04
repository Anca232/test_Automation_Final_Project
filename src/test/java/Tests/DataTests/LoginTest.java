package Tests.DataTests;

import Pages.AccountOptionsPage;
import Pages.LoginPage;
import Tests.DataTests.BaseTest;
import Tests.ObjectModels.LoginModel;
import Utils.SeleniumUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginTest extends BaseTest {

     @DataProvider(name = "jsonDp")
     public Iterator<Object[]> jsonDpCollection() throws IOException {
          Collection<Object[]> dp = new ArrayList<>();

          ObjectMapper objectMapper = new ObjectMapper();

          File f = new File("src\\test\\resources\\data\\testdata.json");
          LoginModel[] lms = objectMapper.readValue(f, LoginModel[].class);

          for (LoginModel lm : lms)
               dp.add(new Object[]{lm});

          return dp.iterator();
     }

     @Test(dataProvider = "jsonDp")
     public void loginWithJson(){
          driver.get(baseUrl + "/customer/account/login/");
          LoginPage lp = new LoginPage(driver);

     }
     @Test
     public void loginBasic(LoginModel lm){
          driver.get(baseUrl + "/customer/account/login/");
          LoginPage lp = new LoginPage(driver);
          lp.verifyPage();
          lp.login("sara_p@gmail.com", "Password2023");
          AccountOptionsPage aop = new AccountOptionsPage(driver);
          aop.verifyPage();
          SeleniumUtils.takeScreenshot(driver);
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
