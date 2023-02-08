package Tests.DataTests;

import Pages.AccountOptionsPage;
import Pages.LoginPage;
import Tests.ObjectModels.LoginModel;
import Utils.ExtentTestManager;
import Utils.GenericUtils;
import Utils.SeleniumUtils;
import Utils.Tools;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class  LoginTest extends BaseTest {
     @Test
     public void loginTest() {
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.get(baseUrl + "/customer/account/login/");
          LoginPage lp = new LoginPage(driver);
          lp.verifyPage();
          lp.login("tested@hotmail.com", "Parola4321");
          AccountOptionsPage acp = new AccountOptionsPage(driver);
          acp.verifyPage();
     }

     @Test
     public void getAccountErrorsTest() {
          driver.get(baseUrl + "/customer/account/login/");
          LoginPage lp = new LoginPage(driver);
          lp.getLoginError();
     }

     @DataProvider(name = "jsonDp")
     public Iterator<Object[]> jsonDpCollection() throws IOException {
          Collection<Object[]> dp = new ArrayList<>();

          ObjectMapper objectMapper = new ObjectMapper();

          File f = new File("src\\test\\Resources\\Data\\testdata.json");
          LoginModel[] lms = objectMapper.readValue(f, LoginModel[].class);

          for (LoginModel lm : lms)
               dp.add(new Object[]{lm});

          return dp.iterator();
     }
     @Test(dataProvider = "jsonDp")
     public void loginWithJsonTest(LoginModel lm){
          printData(lm);
//          loginActions(lm);
     }

     private void printData(LoginModel lm){
          System.out.println("Account:email" + lm.getAccount().getEmail() +
                  "/password:" + lm.getAccount().getPassword());
          System.out.println("Email error:" + lm.getEmailError());
          System.out.println("Password error:" + lm.getPasswordError());
          System.out.println(lm);
     }

     private void loginActions(LoginModel lm){
          LoginPage lp = new LoginPage(driver);

          System.out.println("Open login page");
          driver.get(baseUrl + "/customer/account/login/");

          lp.login(lm.getAccount().getEmail(), lm.getAccount().getPassword());
          System.out.println("Login button was pressed");

          String expectedEmailError = lm.getEmailError();
          String expectedPasswordError = lm.getPasswordError();

          System.out.println("Verify expected errors present: expected emailError:" + expectedEmailError);
          Assert.assertTrue(LoginPage.checkErr(expectedEmailError, "emailErr"));

          System.out.println("Expected Password Error:" + expectedPasswordError);
          Assert.assertTrue(LoginPage.checkErr(expectedPasswordError, "passErr"));
     }

     @DataProvider(name = "SQLdp")
     public Iterator<Object[]> SQLDpCollection() {
          //        get DB connection settings
          System.out.println("Use dbHostname:" + dbHostname);
          System.out.println("Use dbUser:" + dbUser);
          System.out.println("Use dbPort:" + dbPort);
          System.out.println("Use dbPassword:" + dbPassword);
          System.out.println("Use dbSchema:" + dbSchema);

          Collection<Object[]> dp = new ArrayList<>();
          try {
               Connection connection = DriverManager.getConnection("jdbc:mysql://" + dbHostname + ":" + dbPort
                       + "/" + dbSchema, dbUser, new String(base64.decode(dbPassword.getBytes())));
               Statement statement = connection.createStatement();
               ResultSet resultSet = statement.executeQuery("SELECT * FROM login_negativ");
               while (resultSet.next()) {
                    LoginModel lm = new LoginModel(getEscapedElement(resultSet, "username"),
                            getEscapedElement(resultSet, "password"),
                            getEscapedElement(resultSet, "usernameErr"),
                            getEscapedElement(resultSet, "passErr"));
                    dp.add(new Object[]{lm});
               }
          } catch (SQLException ex) {
               ex.printStackTrace();
          }
          return dp.iterator();
     }

     private String getEscapedElement(ResultSet resultSet, String element) throws SQLException {
          return Tools.replaceElements(resultSet.getString(element), "''", "");
     }

     @Test(dataProvider = "SQLdp")
     public void loginWithDBTest(LoginModel lm) {
          printData(lm);
          loginActions(lm);
     }
}
