package com.qa.testdatasupplier;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.sskorol.core.DataSupplier;

import io.github.sskorol.data.JsonReader;
import io.github.sskorol.data.TestDataReader;
import one.util.streamex.StreamEx;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Usecase2 {
    @Test(dataProvider = "getDataUsingSupplier")
    public void test2(User user) {
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
    }

    // Traditional Way to feed data from external source
    @DataProvider
    public Object[] getData() throws IOException {
        List<User> userList = new ObjectMapper()
                .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/user.json"),
                        new TypeReference<List<User>>() {
                        });
        return userList.toArray();
    }

    @DataSupplier
    public StreamEx<User> getDataUsingSupplier(){
        return TestDataReader.use(JsonReader.class)
                .withTarget(User.class)
                .withSource("user.json")
                .read();
    }


}
