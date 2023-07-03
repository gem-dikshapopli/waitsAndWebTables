package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //--------To disable popups
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");


        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.manage().window().maximize();

        //------Print the values of the table column wise
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        List<WebElement> col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td"));

        System.out.println("*******************Col Names***************");
        for(int i=1;i<= col.size();i++){
            for(int j=2;j<= row.size();j++) {
                String companyNames = driver.findElement(By.xpath("//table/tbody/tr["+j+"]/td["+i+"]/span")).getText();
                System.out.println(companyNames);
            }
            System.out.println();
            System.out.println("************************************");
        }

        //------Print the values row wise

        System.out.println("******************Row Wise name***************");
        for(int i=2;i<= row.size();i++){
            for(int j=1;j<= col.size();j++) {
                String rowWiseNames = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]/span")).getText();
                System.out.print(rowWiseNames+" ");
            }
            System.out.println();
        }

        //---Verify that Roland Mendel works in Microsoft and lives in Austria

        System.out.println("**************************************");

        for(int i=2;i<= row.size();i++){
            String name=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]/span")).getText();
            if(name.equals("Roland Mendel")){
                String works=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]/span")).getText();
                String country=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]/span")).getText();
                if(works.equals("Microsoft") && country.equals("Austria")){
                    System.out.println("Verified");
                }
                else{
                    System.out.println("Not Verified");
                }
                break;
            }
        }
        driver.quit();
}
}