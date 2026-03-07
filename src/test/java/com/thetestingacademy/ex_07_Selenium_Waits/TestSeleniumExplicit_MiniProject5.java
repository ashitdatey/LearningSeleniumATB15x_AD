package com.thetestingacademy.ex_07_Selenium_Waits;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.WaitHelpers;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.thetestingacademy.WaitHelpers.checkVisibility;
import static com.thetestingacademy.WaitHelpers.waitImplicitWait;

public class TestSeleniumExplicit_MiniProject5 extends CommonToAll {


    @Description("Verify  makemytrip opens with modal")
    @Test
    public void testCloseModal() {
        WebDriver driver = new ChromeDriver();
        openBrowser(driver,"https://www.makemytrip.com/");
        waitForVisibility(driver,3,"//span[@data-cy='closeModal']");
        clickElementFound("//span[@data-cy='closeModal']");

        // static -
        WaitHelpers.waitJVM(10000);
        closeBrowser(driver);
    }



}
