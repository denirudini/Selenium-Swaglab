package com.juaracoding.ecom.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
 private WebDriver driver;

    private By addCartItemXpath = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button");
    private By buttonCartXpath = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private By totalItemCartXpath = By.xpath("//span[contains(@class, 'shopping_cart_badge') and string-length(text()) > 0]");
    private By removeItemButtonXpath = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/button");
    private By checkoutButtonXpath = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]");
    public static By allProductItems = By.cssSelector(".inventory_item");
    private By addToCartButtons = By.cssSelector(".btn_inventory");
    private By removeButtonLocator = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button");

  public InventoryPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getCurrentURL() {
    return driver.getCurrentUrl();
  }
   public void addItemToCart() {
        driver.findElement(addCartItemXpath).click();
    }

    public void openCart() {
        driver.findElement(buttonCartXpath).click();
    }

    public String getCartItemCount() {
        return driver.findElement(totalItemCartXpath).getText();
    }

    public String removeItem() {
        return driver.findElement(removeItemButtonXpath).getText();

    }

    public void clickCheckout() {
        driver.findElement(checkoutButtonXpath).click();
    }

    public int getTotalProductDisplayed() {
        List<WebElement> products = driver.findElements(allProductItems);
        return products.size();
    }

    public boolean isRemoveButtonExists() {
        return driver.findElements(removeButtonLocator).size() > 0;
    }

}
