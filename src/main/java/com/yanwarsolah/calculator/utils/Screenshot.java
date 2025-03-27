package com.yanwarsolah.calculator.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class Screenshot {

  public static void shoot(AndroidDriver driver, String filename) throws IOException {
    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    Files.copy(srcFile.toPath(), Paths.get(filename));
    System.out.println("Berhasil menyimpan image screenshot..");
  }

  public static void shootByDate(AndroidDriver driver, String step) throws IOException {
    String stamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String folderPath = "screenshots/";
    Files.createDirectories(Paths.get(folderPath));
    // nentuin nama file (kombinasi)
    String filePath = folderPath + step + "_screenshot_" + stamp + ".png";
    Screenshot.shoot(driver, filePath);
  }
}
