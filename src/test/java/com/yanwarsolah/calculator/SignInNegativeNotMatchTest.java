package com.yanwarsolah.calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.yanwarsolah.calculator.screens.SignInScreen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SignInNegativeNotMatchTest {
  private AndroidDriver driver;
  private UiAutomator2Options options;
  private SignInScreen signInScreen;

  @BeforeClass
  public void setup() throws MalformedURLException {
    driver = DriverSingleton.getDriver();
    signInScreen = new SignInScreen(driver);
  }

  @Test(priority = 1)
  @Parameters({ "username" })
  public void fillUsername(String username) {
    signInScreen.setUsername(username);
  }

  @Test(priority = 2)
  @Parameters({ "wrongPassword" })
  public void fillPassword(String password) {
    signInScreen.setPassword(password);
  }

  @Test(priority = 3)
  public void clickLogin() {
    signInScreen.clickLogin();
  }

  @Test(priority = 4)
  @Parameters({ "errorWhenNotMatch" })
  public void compareError(String errorWhenNotMatch) {
    String actual = signInScreen.getErrorMessage(SignInScreen.NOT_MATCH);
    System.out.println(actual);
    Assert.assertEquals(actual, errorWhenNotMatch);
  }
}
