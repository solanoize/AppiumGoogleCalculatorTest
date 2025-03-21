package com.yanwarsolah.calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.yanwarsolah.calculator.screens.CalculatorScreen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CalculatorTest {
  private AndroidDriver driver;
  private UiAutomator2Options options;
  private CalculatorScreen calculatorScreen;

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

    calculatorScreen = new CalculatorScreen(driver);
  }

  @Test(priority = 1)
  public void clickFiveTest() {
    calculatorScreen.clickButtonFive();
  }

  @Test(priority = 2)
  public void clickPlusTest() {
    calculatorScreen.clickButtonPlus();
  }

  @Test(priority = 3)
  public void clickNineTest() {
    calculatorScreen.clickButtonNine();
  }

  @Test(priority = 4)
  public void clickEqualTest() {
    calculatorScreen.clickButtonEqual();
  }

  @Test(priority = 5)
  public void resultTest() {
    String expected = "14";
    String actual = calculatorScreen.getResulFinal();
    Assert.assertEquals(actual, expected);
  }

  @AfterClass
  public void tearDown() throws InterruptedException {
    Thread.sleep(4000);
    driver.quit();
  }
}
