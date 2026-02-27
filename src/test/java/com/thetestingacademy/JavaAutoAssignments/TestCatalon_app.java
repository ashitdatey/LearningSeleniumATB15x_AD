package com.thetestingacademy.JavaAutoAssignments;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCatalon_app {
    @Owner(value = "Ashit")
    @Description("This is an Assignment")
    @Test
    public void Test_App() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement Link_to_Click = driver.findElement(By.id("btn-make-appointment"));
        Link_to_Click.click();
        Thread.sleep(2000);
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement LoginBtn = driver.findElement(By.id("btn-login"));
        LoginBtn.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
        String Currenturl = driver.getCurrentUrl();
        System.out.println("Url is:" + Currenturl);
        String MakeAppointment_Text = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(MakeAppointment_Text,"Make Appointment");
        driver.quit();
    }


}
