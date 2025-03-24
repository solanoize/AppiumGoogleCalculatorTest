package com.yanwarsolah.calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.yanwarsolah.calculator.screens.HomeScreen;
import com.yanwarsolah.calculator.screens.SignInScreen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SignInTest {
  private AndroidDriver driver;
  private SignInScreen signInScreen;
  private HomeScreen homeScreen;

  @BeforeClass
  public void setup() throws MalformedURLException {
    driver = DriverSingleton.getDriver();
    signInScreen = new SignInScreen(driver);
    homeScreen = new HomeScreen(driver);
  }

  @Test(priority = 1)
  @Parameters({ "username" })
  public void fillUsername(String username) {
    signInScreen.setUsername(username);
  }

  @Test(priority = 2)
  @Parameters({ "password" })
  public void fillPassword(String password) {
    signInScreen.setPassword(password);
  }

  @Test(priority = 3)
  public void clickLogin() {
    signInScreen.clickLogin();
  }

  @Test(priority = 4)
  public void isHomeScreen() {
    // Harus berada di screen home
    String expected = "PRODUCTS";
    String actual = homeScreen.getTitle();
    System.out.println("Sekarang berada di screen => " + actual);
    Assert.assertEquals(actual, expected);
  }

  @Test(priority = 5)
  public void logout() {
    homeScreen.openMenu();
    homeScreen.clickLogout();
  }
}
