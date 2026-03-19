package com.thetestingacademy.ex_013_Iframe;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestFrame2 extends CommonToAll {
    @Test
    public void test_frame(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");

        IFrameUtils frameUtils = new IFrameUtils(driver);

        frameUtils.switchToFrame("result");
        driver.findElement(By.id("username")).sendKeys("Pramod");
        frameUtils.switchToDefault();





    }
}
