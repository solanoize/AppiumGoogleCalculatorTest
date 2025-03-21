package com.yanwarsolah.calculator.screens;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorScreen {
  private AndroidDriver driver;
  private By buttonFive = AppiumBy.accessibilityId("5");
  private By buttonNine = AppiumBy.accessibilityId("9");
  private By buttonPlus = AppiumBy.id("com.google.android.calculator:id/op_add");
  private By buttonEqual = AppiumBy.id("com.google.android.calculator:id/eq");
  private By resultFinal = AppiumBy.id("com.google.android.calculator:id/result_final");

  public CalculatorScreen(AndroidDriver driver) {
    this.driver = driver;
  }

  public void clickButtonFive() {
    driver.findElement(buttonFive).click();
  }

  public void clickButtonPlus() {
    driver.findElement(buttonPlus).click();
  }

  public void clickButtonNine() {
    driver.findElement(buttonNine).click();
  }

  public void clickButtonEqual() {
    driver.findElement(buttonEqual).click();
  }

  public String getResulFinal() {
    return driver.findElement(resultFinal).getText();
  }
}
