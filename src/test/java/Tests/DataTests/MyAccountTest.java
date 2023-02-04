package Tests.DataTests;

import Pages.LoginPage;
import Pages.MyAccountPage;
import Tests.ObjectModels.LoginModel;
import Tests.ObjectModels.MyAccountModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyAccountTest extends BaseTest {

//     @DataProvider(name = "jsonDp")
//     public Iterator<Object[]> jsonDpCollection() throws IOException {
//          Collection<Object[]> dp = new ArrayList<>();
//
//          ObjectMapper objectMapper = new ObjectMapper();
//
//          File f = new File("src\\test\\resources\\data\\testdata.json");
//          MyAccountModel[] lms = objectMapper.readValue(f, MyAccountModel[].class);
//
//          for (MyAccountModel lm : lms)
//               dp.add(new Object[]{lm});
//
//          return dp.iterator();
//     }

     @Test
     public void myAccountTest(){
          driver.get(baseUrl + "/customer/account/");
          LoginPage lp = new LoginPage(driver);
          lp.verifyPage();
          lp.login("tibi.pop@gmail.com", "Pass1234!");
          MyAccountPage map = new MyAccountPage(driver);
          map.changePass();
     }
}
