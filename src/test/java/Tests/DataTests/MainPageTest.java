package Tests.DataTests;

import Pages.MainPage;
import Utils.ExtentTestManager;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class MainPageTest extends BaseTest {

     @Test(groups = {"Smoke"})
     public void clickOnSearchBarTest(Method method){
          ExtentTestManager.startTest(method.getName(), "");
          driver.get(baseUrl);
          MainPage mp = new MainPage(driver);
          mp.clickOnAlertButton();
          mp.searchBar("Tractor LS");
          mp.clickOnSearchButton();
     }

     @Test(groups = {"Regression"})
     public void clickOnShoppingCartTest(){
          driver.get(baseUrl);
          MainPage mp = new MainPage(driver);
          mp.goToShoppingCartPage();
     }

     @Test(groups = {"Smoke"})
     public void clickOnSignInTest(Method method){
          ExtentTestManager.startTest(method.getName(), "");
          driver.get(baseUrl);
          MainPage lp = new MainPage(driver);
          lp.clickOnSignIn();
     }
}
