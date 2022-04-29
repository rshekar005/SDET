package com.qa.zerocell;

import com.creditdatamw.zerocell.Reader;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY;

import java.io.File;
import java.util.List;

/**
 * @author Rajashekar.p
 *
 * Below method is used to read excel file and append those values to TestData class and returns it.
 */
public class ZeroCellRunner {
    public static void main(String[] args) {
        //Returns List of values
        List<Object> testDatas=Reader.of(TestData.class)
                .from(new File("zerocell.xlsx"))
                .sheet("Sheet1")
                .skipHeaderRow(true)//column
                .list();
        testDatas.forEach(System.out::println);
    }
}
