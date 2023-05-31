package com.krafttech.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test_01 {

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        /**
         * {
         *   "appium:udid": "3c7eb8",
         *   "appium:version": "12",
         *   "appium:deviceName": "Xaomi Redmi Note 8",
         *   "appium:realDevice": "false",
         *   "platformName": "Android"
         * }
         */

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("appium:udid","3c7eb8");
        capabilities.setCapability("appium:version","12");
        capabilities.setCapability("appium:deviceName","Xaomi Redmi Note 8");
        capabilities.setCapability("platformName","Android");

        // com.getir.casestudy.dev/com.getir.casestudy.modules.login.ui.LoginActivity

        capabilities.setCapability("appium:appPackage","com.getir.casestudy.dev");
        capabilities.setCapability("appium:appActivity","com.getir.casestudy.modules.splash.ui.SplashActivity");

        //driver'ı ayarlayalım

        AppiumDriver<MobileElement> driver;

        driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        Thread.sleep(3000);
        MobileElement userNameBox = driver.findElement(By.xpath("//*[@text='username']"));
        MobileElement passwordBox = driver.findElement(By.xpath("//*[@text='password']"));
        MobileElement submitBtn = driver.findElement(By.xpath("//*[@text='Submit']"));

        Thread.sleep(3000);
        userNameBox.sendKeys("hello@getir.com");
        passwordBox.sendKeys("hello");
        submitBtn.click();

        driver.closeApp();


    }
}
  //WebDriver--->driver --->url
//AppiumDriver----->driver---->Cihaz----->App

