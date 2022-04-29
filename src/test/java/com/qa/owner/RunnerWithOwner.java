package com.qa.owner;

import com.qa.owner.FrameWorkConfig;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;

public class RunnerWithOwner {
    @Test
    public void run() {
        FrameWorkConfig frameWorkConfig = ConfigFactory.create(FrameWorkConfig.class);
        System.out.println(frameWorkConfig.browser().name());
        System.out.println(frameWorkConfig.takesscreenshot());
        System.out.println(frameWorkConfig.favtools());
        System.out.println(frameWorkConfig.timeout());


    }
}
