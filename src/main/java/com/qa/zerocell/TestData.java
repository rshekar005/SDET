package com.qa.zerocell;

import com.creditdatamw.zerocell.annotation.Column;
import com.qa.Enums.BrowserType;
import io.github.sskorol.data.Sheet;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * @author Rajashekar.p
 *
 * With Apache POI library lot code need to be written.
 * Need to convert values based on the requirements.
 *
 * With the help of ZeroCell library we can avoid above drawbacks.
 *
 * 1. Need to create variables for all the columsn
 * 2. If there is conversion like boolean, date, int and pHonenUmber, need to write a converterclass by using Converter Interface which comes from zeroCell.
 * @link:com.qa.zerocell.StringToBooleanConverter
 * 3. Add Column Annotation on top of variable and pass parameters like columnName, index and converterClass
 * 4. Generate Getters() which will be used in dataProviders Concept
 *
 */
@ToString
@Getter
@Sheet(name = "Sheet1")
public class TestData {
    @Column(name = "testcasename", index = 0)
    private String testcasename;
    @Column(name = "browser", index = 1 , converterClass = StringToBrowserType.class)
    private BrowserType browser;
    @Column(name = "firstname", index = 2)
    private String firstname;
    @Column(name = "isFTE", index = 3, converterClass = StringToBooleanCoverter.class)
    private boolean isFTE;
    @Column(name = "age", index = 4, converterClass = StringToIntergerConverter.class)
    private int age;
    @Column(name = "date", index = 5, converterClass = StringToLocalDateConverter.class)
    private LocalDate date;
    @Column(name = "date", index = 6, converterClass = StringToNumberConverter.class)
    private String phonenumber;


}
