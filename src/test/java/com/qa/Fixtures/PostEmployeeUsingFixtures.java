package com.qa.Fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.qa.fixtures.Address;
import com.qa.fixtures.Employee;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostEmployeeUsingFixtures {

    @BeforeSuite
    public void setUp(){
        FixtureFactoryLoader.loadTemplates("com.qa.templates");
    }

    @DataProvider(parallel = true)
    public Object[][] getData(){
        Employee validEmployee=Fixture.from(Employee.class).gimme("valid");
        Employee inValid=Fixture.from(Employee.class).gimme("inValid");
        Employee inValidFirstName=Fixture.from(Employee.class).gimme("inValidFirstName");
        return new Object[][]{
                {validEmployee,201},
                {inValid,500},
                {inValidFirstName,201}
        };



    }

    @Test(dataProvider = "getData")
    public void postEmployee(Employee employee,int statusCode){
        Response response=RestAssured.given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(employee)
                .post("http://localhost:3000/employees");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),statusCode);

    }
}
