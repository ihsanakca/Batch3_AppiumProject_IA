package com.krafttech.tests;

import com.krafttech.utils.App;
import com.krafttech.utils.Device;
import com.krafttech.utils.Driver;
import com.krafttech.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Test_05 {

    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;

    By luserName=By.xpath("//*[@text='username']");

    @Test
    public void test1()  {

        Driver.runAppiumService();
        driver = Driver.getDriver(Device.Redmi_8, App.Getir);

        wait=new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(luserName));


        MobileElement userNameBox = driver.findElement(luserName);
        MobileElement passwordBox = driver.findElement(By.xpath("//*[@text='password']"));
        MobileElement submitBtn = driver.findElement(By.xpath("//*[@text='Submit']"));


        userNameBox.sendKeys("hello@getir.com");
        passwordBox.sendKeys("hello");
        submitBtn.click();

        driver.closeApp();
        Driver.stopAppiumService();


    }


}


