//1. https://awesomeqa.com/hr/web/index.php
//2. Login, Find the first Terminated Employye and click on the Delete
//3. DOn’t Delete just open the popup and stop the scritp.
package com.thetestingacademy.JavaAutoAssignments;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;


public class ToolsQAWebTables {
    @Owner("Ashit")
    @Story("Add Records in Table")
    @Description("QA Test toll add records")
    @Test
    public void AddRecordsQATools() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();


        String[] First_Names = {"Tom", "jerry", "Lucy", "Virat", "Mahi"};
        String[] Last_Names = {"JF", "TF", "Dutt", "Kohli", "Dhoni"};
        String[] Emails = {"tom@test.com", "jerry@test.com", "Lucy@test.com", "Virat@test.com", "Mahi@test.com"};
        String[] Age = {"23", "24", "26", "33", "40"};
        String[] Salary = {"12000", "15000", "33333", "44444", "55555"};
        String[] Department = {"IT", "DEV", "LEGAL", "QA", "TEST"};


        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("addNewRecordButton")).click();
            //driver.findElement(By.id("firstName")).sendKeys(First_Names[i]);
            driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(First_Names[i]);
            driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(Last_Names[i]);
            driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(Emails[i]);
            driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys(Age[i]);
            driver.findElement(By.xpath("//input[@placeholder='Salary']")).sendKeys(Salary[i]);
            driver.findElement(By.xpath("//input[@placeholder='Department']")).sendKeys(Department[i]);
            driver.findElement(By.xpath("//button[@class='btn btn-primary' and @id='submit']")).click();
            Thread.sleep(1000);

        }

        Integer Rows = driver.findElements(By.xpath("//table[@class='-striped -highlight table table-striped table-bordered table-hover']/tbody/tr")).size();
//       Integer Columns = driver.findElements(By.xpath("//table[@class='-striped -highlight table table-striped table-bordered table-hover']/tbody/tr[1]/td")).size();
        System.out.println("Column in Rows are: " + Rows);
//        System.out.println(Columns);

        //table[@class='-striped -highlight table table-striped table-bordered table-hover']/tbody/tr[1]/td[]
        String first_part = "//table[@class='-striped -highlight table table-striped table-bordered table-hover']/tbody/tr[";
        // i
        String second_part = "]/td[";
        // j
        String third_part = "]";
        for (int i = 1; i <= Rows; i++) {
            // XPath for Employment Status column (6th column)
            String Department_Xpath = first_part + i + second_part + 6 + third_part;
            String Dept_Name = driver.findElement(By.xpath(Department_Xpath)).getText();
            if (Dept_Name.equalsIgnoreCase("Legal")) {
                System.out.println("First Legal person Found at Row: " + i);

                // Get First Legal Dept person Name (column 1)
                String firstNameXpath = first_part + i + second_part + 1 + third_part;
                WebElement firstNameElement = driver.findElement(By.xpath(firstNameXpath));
                System.out.println(firstNameElement.getText());

                String deleteXpath = first_part + i + second_part + 7 + third_part + "//span[@title='Delete']";

                WebElement deleteButton = driver.findElement(By.xpath(deleteXpath));
                deleteButton.click();
                Thread.sleep(2000);
                break;

            }

        }
    }
}
