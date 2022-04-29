package com.qa.zerocell;

import com.creditdatamw.zerocell.converter.Converter;
import com.qa.Enums.BrowserType;

public class StringToBrowserType implements Converter<BrowserType> {
    @Override
    public BrowserType convert(String s, String s1, int i) {
        return BrowserType.valueOf(s.toUpperCase());
    }
}
