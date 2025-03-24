package com.yanwarsolah.calculator.screens;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class SignInScreen {
  public static final String NOT_MATCH = "not-match";
  public static final String EMPTY_USERNAME = "empty-username";
  public static final String EMPTY_PASSWORD = "empty-password";

  private AndroidDriver driver;
  private By username = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
  private By password = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
  private By login = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");
  private By errorMessageNotMatch = AppiumBy
      .xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]");
  private By errorMessageEmptyUsername = AppiumBy.xpath("//android.widget.TextView[@text=\"Username is required\"]");
  private By errorMessageEmptyPassword = AppiumBy.xpath("//android.widget.TextView[@text=\"Password is required\"]");

  public SignInScreen(AndroidDriver driver) {
    this.driver = driver;
  }

  public void setUsername(String username) {
    driver.findElement(this.username).sendKeys(username);
  }

  public void setPassword(String password) {
    driver.findElement(this.password).sendKeys(password);
  }

  public void clickLogin() {
    driver.findElement(login).click();
  }

  public String getErrorMessageNotMatch() {
    return driver.findElement(errorMessageNotMatch).getText();
  }

  public String getErrorMessageEmptyUsername() {
    return driver.findElement(errorMessageEmptyUsername).getText();
  }

  public String getErrorMessageEmptyPassword() {
    return driver.findElement(errorMessageEmptyPassword).getText();
  }

  public String getErrorMessage(String errorType) {
    if (errorType.equals(NOT_MATCH)) {
      return getErrorMessageNotMatch();
    } else if (errorType.equals(EMPTY_PASSWORD)) {
      return getErrorMessageEmptyPassword();
    } else if (errorType.equals(EMPTY_USERNAME)) {
      return getErrorMessageEmptyUsername();
    } else {
      return getErrorMessageNotMatch();
    }
  }

}
