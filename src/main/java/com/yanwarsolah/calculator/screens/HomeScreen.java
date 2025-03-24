package com.yanwarsolah.calculator.screens;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomeScreen {
  private AndroidDriver driver;
  private WebDriverWait wait;

  private By title = AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
  private By buttonAddToCartProduct01 = AppiumBy.xpath("(//android.widget.TextView[@text=\"ADD TO CART\"])[1]");
  private By buttonAddToCartProduct02 = AppiumBy.xpath("(//android.widget.TextView[@text=\"ADD TO CART\"])[2]");
  private By buttonRemoveToCartProduct02 = AppiumBy.xpath("(//android.widget.TextView[@text=\"REMOVE\"])[2]");
  private By totalCart = AppiumBy.xpath("//android.widget.TextView[@text=\"1\"]");

  private By menu = AppiumBy
      .xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView");
  private By logout = AppiumBy.xpath("//android.widget.TextView[@text=\"LOGOUT\"]");

  public HomeScreen(AndroidDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
  }

  public String getTitle() {
    return driver.findElement(title).getText();
  }

  public void addToCart() {
    driver.findElement(buttonAddToCartProduct01).click();
    driver.findElement(buttonAddToCartProduct02).click();
  }

  public void removeToCart() {
    driver.findElement(buttonRemoveToCartProduct02).click();
  }

  public String getTotalCart() {
    return driver.findElement(totalCart).getText();
  }

  public void openMenu() {
    driver.findElement(menu).click();
  }

  public void clickLogout() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        logout)).click();
  }

}
