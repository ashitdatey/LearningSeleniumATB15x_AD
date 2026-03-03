package com.thetestingacademy.JavaAutoAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMTableToFindTerminated {
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


        //Columns = //div[@class="oxd-table-card"][1]/div/div[@role="cell"][1];

        String first_part = "//div[@class=\"oxd-table-card\"][";
        // i
        String second_part = "]/div/div[@role='cell'][";
        // j
        String third_part = "]";

        for(int i=1;i <= Rows;i++){
            for(int j = 2; j <= Columns;j++){
                String dynamic_xpath = first_part + i + second_part + j + third_part;
                //System.out.println(dynamic_xpath);
                //div[@class="oxd-table-card"][1]/div/div[@role='cell'][2]
//                System.out.println("==============");
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                //System.out.println(data);

                //To find employment status
                // List<WebElement> Employment_status = driver.findElements(By.xpath("//div[@class=\"oxd-table-card\"][1]/div/div[@role='cell'][6]"));

                    //Find the first terminated employee

            }
            String statusXpath = "//div[@class='oxd-table-card']["+ i +"]/div/div[@role='cell'][6]";
            String status = driver.findElement(By.xpath(statusXpath)).getText();
            if (status.equalsIgnoreCase("Terminated")) {

                String id = driver.findElement(
                                By.xpath("//div[@class='oxd-table-card'][" + i + "]/div/div[@role='cell'][2]")).getText();

                String firstName = driver.findElement(
                                By.xpath("//div[@class='oxd-table-card'][" + i + "]/div/div[@role='cell'][3]")).getText();

                String lastName = driver.findElement(
                                By.xpath("//div[@class='oxd-table-card'][" + i + "]/div/div[@role='cell'][4]")).getText();

                System.out.println("Terminated Employee:");
                System.out.println("ID: " + id);
                System.out.println("Name: " + firstName + " " + lastName);

            }
        }
        driver.quit();

    }
}
