package com.thetestingacademy.ex_013_Iframe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IFrameUtils {
    WebDriver driver;
    public IFrameUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Switch back to main page
    public void switchToDefault() {
        driver.switchTo().defaultContent();
        System.out.println("Switched back to main page");
    }

    // Switch back one level
    public void switchToParent() {
        driver.switchTo().parentFrame();
        System.out.println("Switched to parent frame");
    }

    // Switch into frame safely with explicit wait
    public void switchToFrame(String frameId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
        System.out.println("Switched to frame: " + frameId);
    }
    // Switch into frame safely with explicit wait
    public void switchToFrame(String frameId, Integer timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
        System.out.println("Switched to frame: " + frameId);
    }





}
