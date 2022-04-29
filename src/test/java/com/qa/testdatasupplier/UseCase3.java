package com.qa.testdatasupplier;

import io.github.sskorol.core.DataSupplier;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.Stream;

public class UseCase3 {

    @Test(dataProvider = "getData")
    public void test(String data[]){
        System.out.println(data[0]);
        System.out.println(data[1]);
    }

    /* Here it is retuning list of String[]  -- 1. Raja, Rajatest
                                                2. Sai, Saitest */
    @DataProvider
    public Object[] getData(){
        return Stream.of("Raja","Sai")
                .map(e -> new String[]{e, e+"test"})
        .toArray();
    }


    @DataSupplier(flatMap = true)
    public Stream<String[]> getData1(){
        return Stream.of("raja","sai")
                .map(e -> new String[]{e,e+"test"})
             ;
    }

    @Test(dataProvider = "getData1")
    public void test1(String data1,String data2){
        System.out.println(data1);
        System.out.println(data2);
    }


}
