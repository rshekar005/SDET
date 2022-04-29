package com.qa.testdatasupplier;

import com.qa.zerocell.TestData;
import io.github.sskorol.core.DataSupplier;
import static io.github.sskorol.data.TestDataReader.use;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ReadExcelData {

    @Test(dataProvider = "readDataFromExcel")
    public void testcase1(TestData testData){
        System.out.println(testData.getBrowser());
    }
    @DataSupplier
    public StreamEx<TestData> readDataFromExcel(Method method){
        return use(XlsxReader.class)
                .withTarget(TestData.class)
                .withSource("zerocell.xlsx")
                .read()
           ;
    }
}
