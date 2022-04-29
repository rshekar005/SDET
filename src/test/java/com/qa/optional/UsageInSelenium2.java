package com.qa.optional;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class UsageInSelenium2 {
    WebDriver driver;

    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        List<WebElement> element = driver.findElements(By.xpath("//a"));
        element.stream().findFirst().ifPresent(WebElement::click);

    }
}
