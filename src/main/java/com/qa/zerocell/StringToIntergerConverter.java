package com.qa.zerocell;

import com.creditdatamw.zerocell.converter.Converter;

public class StringToIntergerConverter implements Converter<Integer> {

    @Override
    public Integer convert(String value, String columnName, int rowNumber) {
        return Integer.parseInt(value);
    }
}
