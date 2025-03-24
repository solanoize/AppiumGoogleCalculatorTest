package com.yanwarsolah.calculator;

import java.net.MalformedURLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Hook {

  @BeforeSuite
  @Parameters({ "url", "deviceName" })
  public void setup(String url, String deviceName) throws MalformedURLException {
    DriverSingleton.getDriver(deviceName, url);
  }

  @AfterSuite
  public void tearDown() throws InterruptedException {
    DriverSingleton.exit();
  }
}
