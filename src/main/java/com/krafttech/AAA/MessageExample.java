package com.krafttech.AAA;

import org.openqa.selenium.By;

import java.text.MessageFormat;

public class MessageExample {

static String xPathLocator="{3}(//*[@text=\"{0}\"][{1}])[{2}]";

    public static void main(String[] args) {
        System.out.println(xpathOfText("Profile","3"));

        System.out.println(xPathOfText_2("Ahmet","3","5","//input"));
    }

    static By xpathOfText(String tabName,String index){
        String locator="//*[@text='"+tabName+"'"+index+"]";
        return By.xpath(locator);
    }
    static By xPathOfText_2(String...tabName){
        return By.xpath(MessageFormat.format(xPathLocator,tabName));
    }
}
