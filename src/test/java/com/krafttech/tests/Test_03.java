package com.krafttech.tests;

import com.krafttech.utils.App;
import com.krafttech.utils.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Test_03 {

    AppiumDriverLocalService service;
    Device device=Device.Redmi_8;
    App app=App.Getir;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        service=new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
//                .usingPort(4723)
                .usingAnyFreePort()
                .build();
        service.start();

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("appium:udid",device.udid);
        capabilities.setCapability("appium:version",device.version);
        capabilities.setCapability("appium:deviceName",device.deviceName);
        capabilities.setCapability("platformName",device.platformName);

        capabilities.setCapability("appium:appPackage",app.appPackage);
        capabilities.setCapability("appium:appActivity",app.appActivity);



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


