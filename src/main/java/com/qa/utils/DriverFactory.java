package com.qa.utils;

import com.qa.Enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private DriverFactory(){
    }

    public static WebDriver getDriver(BrowserType browserType){
        if(BrowserType.CHROME== browserType){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if(BrowserType.FIREFOX== browserType){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else{
            throw new RuntimeException("Pass correct browser which is provided in sheet");
        }
    }
}
