package com.juaracoding.ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.juaracoding.ecom.utils.DriverUtils;

public class PreCondition {
  @BeforeMethod
  @Parameters({ "baseURL", "username", "password" })
  public void setup(String baseURL, String username, String password) throws InterruptedException {
    WebDriver driver = DriverUtils.getDriver();

    driver.get(baseURL);

    WebElement inputUsername = driver.findElement(By.id("user-name"));
    inputUsername.sendKeys(username);

    Thread.sleep(1000);

    WebElement inputPassword = driver.findElement(By.id("password"));
    inputPassword.sendKeys(password);

    Thread.sleep(1000);

    WebElement buttonLogin = driver.findElement(By.id("login-button"));
    buttonLogin.click();
  }

  @AfterSuite
  public void teardown() throws InterruptedException {
    Thread.sleep(2000);
    DriverUtils.quitDriver();
  }
}
