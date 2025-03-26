package com.yanwarsolah.calculator.screens;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CartScreen {
  private AndroidDriver driver;

  private By scrollView = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-Cart Content\"]");
  private By item = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Item\"]");
  private By totalCart = AppiumBy.xpath(
      "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView[@text]");
  private By title = AppiumBy
      .xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
  private By deleteButton = AppiumBy
      .xpath("//android.view.ViewGroup[@content-desc=\"test-Delete\"]/android.view.ViewGroup/android.view.ViewGroup");

  public CartScreen(AndroidDriver driver) {
    this.driver = driver;
  }

  public String getTotalCart() {
    return driver.findElement(totalCart).getText();
  }

  public void testCart() {
    for (WebElement product : driver.findElements(title)) {
      System.out.println(product.getText());
    }
  }

  public void swipe(String direction) {
    WebElement itemElement = driver.findElement(item);
    Rectangle rectangle = itemElement.getRect();

    int elementX = rectangle.getX();
    int elementY = rectangle.getY();
    int elementWidth = rectangle.getWidth();
    int elementHeight = rectangle.getHeight();

    // titik awal jari kita pengen ada di tengah
    int startX = elementX + (elementWidth / 2);
    int startY = elementY + (elementHeight / 2);
    int endX = startX;
    int endY = startY;

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    Sequence swipe = new Sequence(finger, 0);

    switch (direction.toLowerCase()) {
      case "up":
        endY = startY - (elementHeight / 2);
        break;
      case "down":
        endY = startY + (elementHeight / 2);
        break;
      case "left":
        endX = startX - (elementWidth / 2);
        break;
      case "right":
        endX = startX + (elementWidth / 2);
        break;
      default:
        endX = startX - (elementWidth / 2);
    }

    // jempol kita nyentuh layar di titik awal
    swipe.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), startX, startY));
    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

    // jempol mesti geser ke titik akhir
    swipe.addAction(finger.createPointerMove(
        Duration.ofMillis(500),
        PointerInput.Origin.viewport(),
        endX, endY));
    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    // niatin buat jalanin
    driver.perform(Collections.singletonList(swipe));
  }

  public void removeItem() {
    driver.findElement(deleteButton).click();
  }

}
