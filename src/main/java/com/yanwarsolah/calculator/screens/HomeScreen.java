package com.yanwarsolah.calculator.screens;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
  private By totalCart = AppiumBy.xpath(
      "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView[@text]");

  private By menu = AppiumBy
      .xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView");
  private By logout = AppiumBy.xpath("//android.widget.TextView[@text=\"LOGOUT\"]");

  private By buttonDrag = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Drag Handle\"]");
  private By scrollView = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]");

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

  public void clickCart() {
    driver.findElement(totalCart).click();
  }

  public void openMenu() {
    driver.findElement(menu).click();
  }

  public void scrollProducts() {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    Map<String, Object> params = new HashMap<>();
    params.put("elementId", driver.findElement(scrollView));
    params.put("direction", "down"); // "up", "down", "left", "right"
    params.put("percent", 0.3); // seberapa besar area yang lo mau geser (0.0 - 1.0);
    params.put("speed", 1000);

    js.executeScript("mobile: scrollGesture", params);
  }

  public void accessButtonDrag() {
    ArrayList<WebElement> elements = new ArrayList<>(driver.findElements(buttonDrag));
    System.out.println("Jumlah: " + elements.size());
  }

  public void dragToCart() {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    WebElement drag = new ArrayList<>(driver.findElements(buttonDrag)).get(0);
    WebElement drop = driver.findElement(scrollView);

    Map<String, Object> params = new HashMap<>();
    params.put("elementId", drag);
    params.put("endX", drop.getLocation().getX());
    params.put("endY", drop.getLocation().getY() - 45);
    params.put("speed", 5000);

    js.executeScript("mobile: dragGesture", params);
  }

  public void dragToCarts() {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // WebElement drag = new ArrayList<>(driver.findElements(buttonDrag)).get(0);
    WebElement drop = driver.findElement(scrollView);

    for (WebElement drag : driver.findElements(buttonDrag)) {
      Map<String, Object> params = new HashMap<>();
      params.put("elementId", drag);
      params.put("endX", drop.getLocation().getX());
      params.put("endY", drop.getLocation().getY() - 45);
      params.put("speed", 5000);
      js.executeScript("mobile: dragGesture", params);
    }
  }

  public void clickLogout() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        logout)).click();
  }

}
