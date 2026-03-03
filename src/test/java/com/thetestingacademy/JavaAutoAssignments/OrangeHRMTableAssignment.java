package com.thetestingacademy.JavaAutoAssignments;

//1. https://awesomeqa.com/hr/web/index.php
//2. Login, Find the first Terminated Employye and click on the Delete
//3. DOn’t Delete just open the popup and stop the scritp.
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMTableAssignment {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        //user logs in
        Thread.sleep(2000);
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        //name("username"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        username.sendKeys("admin");
        password.sendKeys("Hacker@4321");
        WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
        Submit.click();
        Thread.sleep(2000);

        //find rows:
        //div[@role="table"]/div[@class="oxd-table-body"]/div[@class="oxd-table-card"]
        //div[@class="orangehrm-container"]/div/div/div[@class="oxd-table-card"]
        //WebElement table = driver.findElement(By.xpath("//div[@class='orangehrm-container']"));
        Integer Rows = driver.findElements(By.xpath("//div[@class='oxd-table-card']")).size();
        Integer Columns = driver.findElements(By.xpath("//div[@class='oxd-table-card'][1]/div/div[@role='cell']")).size();

        //Columns = //div[@class="oxd-table-card"][1]/div/div[@role="cell"];

        String first_part = "//div[@class=\"oxd-table-card\"][";
        // i
        String second_part = "]/div/div[@role='cell'][";
        // j
        String third_part = "]";

        for (int i = 1; i <= Rows; i++) {
                // XPath for Employment Status column (6th column)
                String Employment_Status = first_part + i + second_part + 6 + third_part;
                String Status = driver.findElement(By.xpath(Employment_Status)).getText();
            if (Status.equalsIgnoreCase("Terminated")) {

                System.out.println("First Terminated Employee Found at Row: " + i);

                // Get First Name (column 3)
                String firstNameXpath = first_part + i + second_part + 3 + third_part;
                WebElement firstNameElement = driver.findElement(By.xpath(firstNameXpath));
//Delete button xpath: //div[@role="cell"][9]/div/button/i[contains(@class,'oxd-icon bi-trash')][1]
                String deleteXpath = first_part + i + second_part + 9 + third_part + "//i[contains(@class,'bi-trash')]";

                WebElement deleteButton = driver.findElement(By.xpath(deleteXpath));
                deleteButton.click();
                break;  // Stop after first terminated employee
            }


            }
       // driver.quit();
        }


}

