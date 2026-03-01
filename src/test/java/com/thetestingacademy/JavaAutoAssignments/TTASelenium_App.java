package com.thetestingacademy.JavaAutoAssignments;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class TTASelenium_App {
    @Owner("Ashit")
    @Description("This is Selenium Practice")
    @Test
    public void TTABankAccount() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");

        WebElement Signup = driver.findElement(By.xpath("//button[text() = 'Sign Up']"));
        Signup.click();

        WebElement FullName = driver.findElement(By.xpath("//input[@placeholder='John Doe']"));
        FullName.sendKeys("Ashish Datey");

        WebElement Email = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        Email.sendKeys("ashishpatiljio@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@type=\"password\"]"));
        password.sendKeys("AshishD");

        WebElement Submit = driver.findElement(By.xpath("//button[(text()='Create Account')]"));
        Submit.click();

        Thread.sleep(2000);

        WebElement FundTransfer = driver.findElement(By.xpath("//button[contains(text(), \'Transfer Funds\')]"));
        // //button[contains(text(),'Transfer Funds')]
        FundTransfer.click();
        WebElement Amount = driver.findElement(By.xpath("//input[@type=\'number\']"));
        Amount.sendKeys("5000");

        WebElement Rent = driver.findElement(By.xpath("//input[@type='text']"));
        Rent.sendKeys("Testing Fund Transfer");

        WebElement Continue = driver.findElement(By.xpath("//button[text()='Continue']"));
        Continue.click();

        WebElement Confirmtransfer = driver.findElement(By.xpath("//button[text()='Confirm Transfer']"));
        Confirmtransfer.click();
        WebElement Dashboard = driver.findElement(By.xpath("//button[normalize-space()='Dashboard']"));
        Dashboard.click();

        WebElement TotalFund = driver.findElement(By.xpath("//h3[@class='mt-2 text-3xl font-bold']"));
        Assert.assertEquals(TotalFund.getText(), "$45,000.00");
        System.out.println("Reduced Funds" +TotalFund.getText());
        driver.quit();
    }
}