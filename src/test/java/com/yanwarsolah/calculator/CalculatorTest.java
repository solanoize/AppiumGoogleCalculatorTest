package com.yanwarsolah.calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CalculatorTest {
  AndroidDriver driver;
  UiAutomator2Options options;

  @BeforeClass
  public void setup() throws MalformedURLException {
    options = new UiAutomator2Options();
    options.setCapability("platformName", "Android");
    options.setCapability("appium:deviceName", "RR8T90084BR");
    options.setCapability("appium:appPackage", "com.google.android.calculator");
    options.setCapability("appium:appActivity", "com.android.calculator2.Calculator");

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.hideKeyboard();
  }

  @Test(priority = 1)
  public void clickFiveTest() {
    WebElement buttonFive = driver.findElement(AppiumBy.accessibilityId("5"));
    buttonFive.click();
  }

  @Test(priority = 2)
  public void clickPlusTest() {
    WebElement buttonPlus = driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add"));
    buttonPlus.click();
  }

  @Test(priority = 3)
  public void clickNineTest() {
    WebElement buttonNine = driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"9\"]"));
    buttonNine.click();
  }

  @Test(priority = 4)
  public void clickEqualTest() {
    WebElement buttonEqual = driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq"));
    buttonEqual.click();
  }

  @Test(priority = 5)
  public void resultTest() {
    WebElement result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final"));
    String expected = "14";
    String actual = result.getText();
    Assert.assertEquals(actual, expected);
  }

  @AfterClass
  public void tearDown() throws InterruptedException {
    Thread.sleep(4000);
    driver.quit();
  }
}
