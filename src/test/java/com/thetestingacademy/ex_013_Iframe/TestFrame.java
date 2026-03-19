package com.thetestingacademy.ex_013_Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestFrame {
    @Test
    public void test_frame(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");

        driver.switchTo().frame("result");
        driver.findElement(By.id("username")).sendKeys("Pramod");


        driver.switchTo().defaultContent();





    }
}
