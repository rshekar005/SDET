package com.qa.environment;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;

public class RunnerWithOwnerForManagingEnvironment{

    @Test
    public void run(){
        Environment environment=ConfigFactory.create(Environment.class);
        System.out.println(environment.browser());
        System.out.println(environment.environment());
        System.out.println(environment.username());
        System.out.println(environment.url());
    }

}
