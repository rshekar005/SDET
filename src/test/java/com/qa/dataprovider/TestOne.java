package com.qa.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestOne {

    @Test(dataProvider = "getData")
    public void test1(int a, int b){
        System.out.println(a+" "+b);
    }

    @DataProvider
    public Object[] getData(){
        return  new Object[][]{
                {1,2},
                {3,4}
        };
    }
}
