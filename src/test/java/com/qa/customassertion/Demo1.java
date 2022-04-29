package com.qa.customassertion;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Demo1 {

    Favfoods foods = Favfoods.builder().breakfast("Idly").dinner(Arrays.asList("Roti", "Curry")).build();
    Person person = Person.builder().firstname("Rajashekar").jobs(Arrays.asList("xyz", "abc")).favfoods(foods).build();

    @Test
    public void test() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(person)
                .post("http://localhost:3000/person");
        System.out.println(response.jsonPath().prettyPrint());
        System.out.println(response.getStatusCode());

        Person responsePerson = response.as(Person.class);
        /*Assert.assertEquals(201, response.getStatusCode());
        Assert.assertTrue(response.getContentType().contains("application/json"));
        Assert.assertEquals(response.jsonPath().getString("firstname"),"Rajashekar");*/

        PersonAssert.assertThat(responsePerson)
                .hasName()
                .hasListOfJobs();


        ResponseAssert.assertThat(response)
                .isSuccessFulPostResponse()
                .hasHeaderApplicationJson()
                .hasCacheControlHeader();


    }
}
