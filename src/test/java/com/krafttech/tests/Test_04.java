package com.krafttech.tests;

import com.krafttech.utils.App;
import com.krafttech.utils.Device;
import com.krafttech.utils.Driver;
import com.krafttech.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Test_04 {

    Device device = Device.Redmi_8;
    App app = App.Getir;
    AppiumDriver<MobileElement> driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        Driver.runAppiumService();
        driver = Driver.getDriver(Device.Redmi_8, App.Getir);

        Thread.sleep(3000);
        MobileElement userNameBox = driver.findElement(By.xpath("//*[@text='username']"));
        MobileElement passwordBox = driver.findElement(By.xpath("//*[@text='password']"));
        MobileElement submitBtn = driver.findElement(By.xpath("//*[@text='Submit']"));

        Thread.sleep(3000);
        userNameBox.sendKeys("hello@getir.com");
        passwordBox.sendKeys("hello");
        submitBtn.click();

        driver.closeApp();
        Driver.stopAppiumService();


    }

    @Test
    public void test2() throws MalformedURLException, InterruptedException {

        driver = Utils.openApp(Device.Redmi_8, App.Getir);

        Thread.sleep(3000);
        MobileElement userNameBox = driver.findElement(By.xpath("//*[@text='username']"));
        MobileElement passwordBox = driver.findElement(By.xpath("//*[@text='password']"));
        MobileElement submitBtn = driver.findElement(By.xpath("//*[@text='Submit']"));

        Thread.sleep(3000);
        userNameBox.sendKeys("hello@getir.com");
        passwordBox.sendKeys("hello");
        submitBtn.click();

        driver.closeApp();
        Driver.stopAppiumService();


    }
}


