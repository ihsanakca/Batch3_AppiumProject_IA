package com.krafttech.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test_02 {

    AppiumDriverLocalService service;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        service=new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
//                .usingPort(4723)
                .usingAnyFreePort()
                .build();
        service.start();

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("appium:udid","3c7eb8");
        capabilities.setCapability("appium:version","12");
        capabilities.setCapability("appium:deviceName","Xaomi Redmi Note 8");
        capabilities.setCapability("platformName","Android");



        capabilities.setCapability("appium:appPackage","com.getir.casestudy.dev");
        capabilities.setCapability("appium:appActivity","com.getir.casestudy.modules.splash.ui.SplashActivity");



        AppiumDriver<MobileElement> driver;

        driver=new AndroidDriver<MobileElement>(service.getUrl(),capabilities);

        Thread.sleep(3000);
        MobileElement userNameBox = driver.findElement(By.xpath("//*[@text='username']"));
        MobileElement passwordBox = driver.findElement(By.xpath("//*[@text='password']"));
        MobileElement submitBtn = driver.findElement(By.xpath("//*[@text='Submit']"));

        Thread.sleep(3000);
        userNameBox.sendKeys("hello@getir.com");
        passwordBox.sendKeys("hello");
        submitBtn.click();

        driver.closeApp();
        service.stop();


    }
}


