package com.juaracoding.ecom;

import com.juaracoding.ecom.utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    @BeforeMethod
    @Parameters({ "baseURL", "username", "password" })
    public void setup(
            @Optional("https://www.saucedemo.com/v1/index.html") String baseURL,
            @Optional("standard_user") String username,
            @Optional("secret_sauce") String password
    ) throws InterruptedException {
        WebDriver driver = DriverUtil.getDriver();

        driver.get(baseURL);

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys(username);

        Thread.sleep(1000);

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys(password);

        Thread.sleep(2000);

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(4000);
        try {
            DriverUtil.quitDriver();
        } catch (Exception e) {
            System.out.println("Browser tertutup: " + e.getMessage());
        }
    }
}