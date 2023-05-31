package test.day1;

import com.krafttech.WebDriverMobile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MobileChromeTest {
WebDriver driver= WebDriverMobile.getMobileWebDriver();
    @Test
    public void test1() throws InterruptedException {

        driver.get("https://www.krafttechexlab.com/login");
        System.out.println(driver.getTitle());

        driver.findElement(By.id("email")).sendKeys("mgezer@gmail.com");
        driver.findElement(By.id("yourPassword")).sendKeys("Mg12345678"+ Keys.TAB);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Login']")).click();
        Thread.sleep(2000);
        driver.close();


    }
}
