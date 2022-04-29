package com.qa.testdatasupplier;

import io.github.sskorol.core.DataSupplier;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Rajashekar.p
 *
 *  It is a wrapper for TestNG Data provider with additional features.
 *  No need to write logic to read from external files like CSV, JSON, YAML.
 *  It has implementation to read from external files.
 *
 *  Unlike DataProvider it will return Stream, List, StreamEx, Collection etc.
 *  Whereas in dataprovider it returns only Iterator<Object[]> or Object[][]
 */
public class UseCase1 {

    //uses indices: Test method will feed data which contains data in 0,2 indices. It means it will feed (3,10) to test method
    @DataSupplier(indices = {0,2})
    public Stream<Integer> getData() {
        return Stream.of(3, 4, 10);
    }

    /*
        Suppose there is 3 *1 matrix, it means it runs data 3 times with single parameter.
        If we use transpose, then it will run only ones by feeding 3 parameters (1*3)
     */
    @DataSupplier(transpose = true)
    public Stream<Integer> getData2() {
        return Stream.of(3, 4, 10);
    }

    @DataProvider
    public Object[] getData1(){
        return new Object[][]{
                {1},
                {2},
                {3}
        };
      /*  List<Integer> list= Arrays.asList(1,2,3);
        return list.toArray();*/

    }
    @Test(dataProvider = "getData")
    public void test1(int a) {
        System.out.println(a);
    }

    @Test(dataProvider = "getData2")
    public void test2(int a, int b, int c) {
        System.out.println(a);
    }
  }
