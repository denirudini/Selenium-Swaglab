package com.juaracoding.ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juaracoding.ecom.pages.InventoryPage;
import com.juaracoding.ecom.pages.LoginPage;
import com.juaracoding.ecom.providers.DataTestProvider;
import com.juaracoding.ecom.utils.DriverManager;
import com.juaracoding.ecom.utils.LoginUtil;

@Listeners(ListenerTest.class)
public class AuthenticationTest {

   @Test(dataProvider = "loginDataProvider", dataProviderClass = DataTestProvider.class)
  public void loginTest(String username, String password, String expected) throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();

    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginPage loginPage = new LoginPage(driver);

    loginPage.performLogin(username, password);
    String actual = loginPage.getErrorMessage();

    if (actual == null) {
      InventoryPage inventoryPage = new InventoryPage(driver);
      actual = inventoryPage.getCurrentURL();
    }

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();

  }

   @Test(dataProvider = "loginDataProvider", dataProviderClass = DataTestProvider.class, enabled = false)
  public void loginTest1(String username, String password, String errorMessage) throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();

    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginPage loginPage = new LoginPage(driver);

    loginPage.performLogin(username, password);

    if (loginPage.getErrorMessage() != null) {
      String actual = loginPage.getErrorMessage();
      Assert.assertEquals(actual, errorMessage);
    } else {
      InventoryPage inventoryPage = new InventoryPage(driver);
      String actual = inventoryPage.getCurrentURL();
      String expected = "https://www.saucedemo.com/v1/inventory.html";
      Assert.assertEquals(actual, expected);
    }

    driverManager.quitDriver();

  }


  @Test(enabled = false)
  public void loginWithInvalidUsername() throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();

    driver.get("https://www.saucedemo.com/v1/index.html");
    LoginUtil.performLogin(driver, "jonosebastian", "secret_sauce");

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

    String expected = "Epic sadface: Username and password do not match any user in this service";
    String actual = errorValidation.getText();

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }

  @Test(enabled = false)
  public void loginWithInvalidPassword() throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();

    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver, "standard_user", "secret_sambel");

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

    String expected = "Epic sadface: Username and password do not match any user in this service";
    String actual = errorValidation.getText();

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }

  @Test(enabled = false)
  public void loginWithoutPassword() throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();

    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver, "standard_user", "");

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

    String expected = "Epic sadface: Password is required";
    String actual = errorValidation.getText();

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }

  @Test(enabled = false)
  public void loginWithoutUsername() throws InterruptedException {
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();

    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver, "", "secret_sauce");

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

    String expected = "Epic sadface: Username is required";
    String actual = errorValidation.getText();

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }
}
