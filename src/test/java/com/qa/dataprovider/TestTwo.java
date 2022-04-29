package com.qa.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestTwo {
    @Test(dataProvider = "getData")
    public void test2(int a, int b){
        System.out.println(a+" "+b);
    }

    @DataProvider
    public Object[] getData(){
        return  new Object[][]{
                {5,6},
                {7,8}
        };
    }
}
