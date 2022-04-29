package com.qa.optional;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Optional;

public class UsageInSelenium {

    WebDriver driver;

    @Test
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.google.com");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
       // javascriptExecutor.executeScript("alert('Welcome to alert');");

        Thread.sleep(3000);

        /*
        System.out.println("*********** Traditional Way *************");
          try{
            Alert alert=driver.switchTo().alert();
            alert.accept();
          }catch (Exception e){
            System.out.println(e);
            System.out.println("No such alert");
        }*/

        System.out.println("******* Using Optional class *********");
        Optional.ofNullable(ExpectedConditions.alertIsPresent().apply(driver)).
                ifPresentOrElse(Alert::accept, () -> System.out.println("No such alert"));
        driver.quit();
    }
}
