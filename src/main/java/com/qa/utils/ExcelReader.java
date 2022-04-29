package com.qa.utils;

import com.creditdatamw.zerocell.Reader;
import com.qa.zerocell.TestData;

import java.io.File;
import java.util.List;

public final class ExcelReader {
    private ExcelReader(){}
    private static List<TestData> testDataList=null;
    public static List<TestData> getTestDataList() {
        return testDataList;
    }
    static {
        testDataList= Reader.of(TestData.class)
                .from(new File("zerocell.xlsx"))
                .sheet("Sheet1")
                .skipHeaderRow(true)//column
                .list();
    }
}
