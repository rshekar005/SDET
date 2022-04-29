package com.qa.noexception;

import com.machinezoo.noexception.Exceptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumUsecase {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.google.com");

       /* System.out.println("*********** Traditional Way *************");
        try{
            driver.findElement(By.id("name")).click();
        }catch(Exception e){
            System.out.println(e);
            driver.findElement(By.name("q")).click();
        }*/

        System.out.println("********** Using Exceptions class *************");
        Exceptions.silence().get(() -> driver.findElement(By.name("hello")))
                .orElseGet(() -> driver.findElement(By.name("q")))
                .click();
        driver.quit();
    }
}
