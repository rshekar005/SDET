package com.qa.zerocell;

import com.creditdatamw.zerocell.converter.Converter;

public class StringToNumberConverter implements Converter<String> {
    @Override
    public String convert(String value, String columnName, int rowNumber) {
        return value.startsWith("+91") ? value :"+91"+value;
    }
}
