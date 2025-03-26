package com.yanwarsolah.calculator;

import java.net.MalformedURLException;
import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.yanwarsolah.calculator.screens.CartScreen;

import io.appium.java_client.android.AndroidDriver;

public class CartTest {
  private AndroidDriver driver;
  private CartScreen cartScreen;

  @BeforeClass
  public void setup() throws MalformedURLException {
    driver = DriverSingleton.getDriver();
    cartScreen = new CartScreen(driver);
  }

  @Test
  public void demoTest() {
    cartScreen.testCart();
    cartScreen.swipe("left");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    cartScreen.removeItem();
  }
}
