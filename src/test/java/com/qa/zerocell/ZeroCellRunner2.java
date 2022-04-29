package com.qa.zerocell;

import com.qa.utils.DriverFactory;
import com.qa.utils.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class ZeroCellRunner2 {
    @Test(dataProvider = "getData")
    public void test(TestData data) {
        System.out.println(data.getBrowser());
        WebDriver driver = DriverFactory.getDriver(data.getBrowser());
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys(data.getFirstname());
        driver.quit();
    }

    @DataProvider(parallel = true)
    public Object[] getData() {
        List<TestData> testData = ExcelReader.getTestDataList();
        return testData.toArray();
    }

}
