package com.yanwarsolah.calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidManager {
  public static AndroidDriver buildDriver(String deviceName, String url) throws MalformedURLException {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setCapability("platformName", "Android");
    options.setCapability("appium:deviceName", deviceName);
    options.setCapability("appium:appPackage", "com.swaglabsmobileapp");
    options.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");

    AndroidDriver driver = new AndroidDriver(new URL(url), options);

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.hideKeyboard();

    return driver;
  }
}
