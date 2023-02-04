package Tests.DataTests;

import Pages.MainPage;
import Tests.DataTests.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

     @Test(groups = {"Regression"})
     public void clickOnSearchBarTest(){
          driver.get(baseUrl);
          MainPage mp = new MainPage(driver);
          mp.clickOnAlertButton();
          mp.searchBar("Tractor LS");
          mp.clickOnSearchButton();
     }

     @Test
     public void clickOnShoppingCartTest(){
          driver.get(baseUrl);
          MainPage mp = new MainPage(driver);
          mp.goToShoppingCartPage();
          Assert.assertEquals(driver.findElement(By.cssSelector("#minicart-content-wrapper > div.block-title > strong > span.text > span")).getText(), "COSUL DE CUMPARATURI");
     }

     @Test(groups = {"Smoke"})
     public void clickOnSignInTest(){
          driver.get(baseUrl);
          MainPage lp = new MainPage(driver);
          lp.clickOnSignIn();
     }
}
