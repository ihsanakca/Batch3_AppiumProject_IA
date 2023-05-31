package com.krafttech.cucumber;

import com.krafttech.utils.App;
import com.krafttech.utils.Device;
import com.krafttech.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;


import java.util.List;

public class CalStepDefs {
    AppiumDriver<MobileElement> driver;
    @Given("The user is start page")
    public void theUserIsStartPage() {
        driver= Utils.openApp(Device.Redmi_8, App.Calculator);
    }

    @When("The user sum of following numbers")
    public void TheUserSumOfFollowingNumbers(DataTable table) {
        List<Integer> list=table.asList(Integer.class);

        int size= list.size();
        int max=1;

        for (Integer num : list) {
            click(num);
            if(max!=size){
                click("artı");
            }
            max++;
        }

//        click(list.get(0));
//        click("artı");
//        click(list.get(1));
//        click("artı");
//        click(list.get(2));


        click("eşittir");

    }

    @Then("The result should be {int}")
    public void theResultShouldBe(int result) {
        String actualNumber = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        Assert.assertEquals(Integer.parseInt(actualNumber),result);
    }

    void click(int num){
        if (num>=0&&num<=9){
            driver.findElement(By.xpath("//*[@content-desc='"+num+"']")).click();
        }

    }
    void click(String operation){
        driver.findElement(By.xpath("//*[@content-desc='"+operation+"']")).click();
    }
}
