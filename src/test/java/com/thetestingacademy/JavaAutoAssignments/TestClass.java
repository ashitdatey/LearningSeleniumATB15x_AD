package com.thetestingacademy.JavaAutoAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class TestClass {
    static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        //user logs in
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        //name("username"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        username.sendKeys("admin");
        password.sendKeys("Hacker@4321");
        WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
        Submit.click();

        List<WebElement> First_TerminatedEmp = driver.findElements(By.xpath("//div[text()=\"Terminated\"]"));
        WebElement First_TerminatedEmpName = driver.findElement(By.xpath("//div[contains(text(),'Terminated')]/preceding-sibling::div[3]"));
        System.out.println(First_TerminatedEmpName.getText());
        WebElement DeleteFirst_terminatedEmp = driver.findElement(By.xpath( "//div[text()=\"Terminated\"]/following::i[1]"));
        DeleteFirst_terminatedEmp.click();


        WebElement deletePopup=driver.findElement(By.xpath("//p[@class=\"oxd-text oxd-text--p oxd-text--card-body\"]"));
        Thread.sleep(2000);
        String Delete_Popup=deletePopup.getText();
        Assert.assertEquals(Delete_Popup,"The selected record will be permanently deleted. Are you sure you want to continue?");

//        List<WebElement> Employment_status = driver.findElements(By.xpath("//div[@class=\"oxd-table-card\"][1]/div/div[@role='cell'][6]"));
        //Employment_status
//        if (data.contains("Terminated")) {
//            String country_path = dynamic_xpath + "/following-sibling::td";
//            String country_path_text = driver.findElement(By.xpath(country_path)).getText();
//            String company_path = dynamic_xpath + "/preceding-sibling::td";
//            String company_path_text = driver.findElement(By.xpath(company_path)).getText();
//
//            System.out.println("----");
//            System.out.println("Employment Status  - " + country_path_text + " - " + company_path_text);

        }
    }
