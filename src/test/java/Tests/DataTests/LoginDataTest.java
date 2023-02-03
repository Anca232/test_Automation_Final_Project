package Tests.DataTests;

import Pages.LoginPage;
import Tests.ObjectModels.LoginModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginDataTest extends BaseTest {

//     @DataProvider(name = "jsonDp")
//     public Iterator<Object[]> jsonDpCollection() throws IOException {
//          Collection<Object[]> dp = new ArrayList<>();
//
//          ObjectMapper objectMapper = new ObjectMapper();
//
//          File f = new File("src\\test\\resources\\data\\testdata.json");
//          LoginModel[] lms = objectMapper.readValue(f, LoginModel[].class);
//
//          for (LoginModel lm : lms)
//               dp.add(new Object[]{lm});
//
//          return dp.iterator();
//     }
//     @Test(dataProvider = "jsonDp")
//     public void loginWithJsonTest(LoginModel lm) {
//          printData(lm);
//          loginActions(lm);
//     }

     public LoginModel unMarshallLoginModel(File f) {
          try {
               JAXBContext jaxbContext = JAXBContext.newInstance(LoginModel.class);
               Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
               return (LoginModel) jaxbUnmarshaller.unmarshal(f);
          } catch (JAXBException ex) {
               ex.printStackTrace();
               return null;
          }
     }

     @DataProvider(name = "xmlDp")
     public Iterator<Object[]> xmlDpCollection() {
          Collection<Object[]> dp = new ArrayList<>();
          File f = new File("src\\test\\resources\\data\\testdata.xml");
          LoginModel lm = unMarshallLoginModel(f);
          dp.add(new Object[]{lm});
          return dp.iterator();
     }
     public void printData(LoginModel lm) {
          System.out.println(lm);
     }

     @Test(dataProvider = "xmlDp")
     public void loginWithXMLTest(LoginModel lm) {
          printData(lm);
          loginActions(lm);
     }

     public void loginActions(LoginModel lm) {
          LoginPage loginPage = new LoginPage(driver);

          System.out.println("Open Login page");
          driver.get(baseUrl + "/customer/account/login/");

          loginPage.login(lm.getAccount().getUsername(), lm.getAccount().getPassword());
          System.out.println("Login button was pressed");
     }

}
