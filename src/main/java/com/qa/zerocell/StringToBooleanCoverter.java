package com.qa.zerocell;

import com.creditdatamw.zerocell.converter.Converter;

/**
 * @author Rajashekar.p
 * <p>
 * This class is used to convert String to boolean and this classname need to pass as an argument in the annotation.
 */
public class StringToBooleanCoverter implements Converter<Boolean> {
    @Override
    public Boolean convert(String value, String columnName, int rowNumber) {
        return Boolean.valueOf(value);
    }
}
