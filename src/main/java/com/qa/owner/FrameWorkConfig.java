package com.qa.owner;

import com.qa.Enums.BrowserType;
import org.aeonbits.owner.Config;
import org.checkerframework.checker.units.qual.K;

import java.util.List;

/**
 * @author Rajashekar.p
 *
 * Drawbacks of Traditional Way of fetching property files
 * 1. We need to do type casting
 * 2. Lot of code
 *
 * With the help of owner library we can avoid above drawbacks
 * Create an interface and Need to extend Config Interface
 * Abstract method name should be same as key in property.
 * If not same then need to use @key annotation on top of method.
 * We can set default value to paramater using @DefaultValue annotation
 *
 * If property file and equivalent interface is in same package then no need to set file source like below (@Config...)
 *
 */
@Config.Sources(value = "file:${user.dir}/src/test/resources/FrameworkConfig.properties")
public interface FrameWorkConfig extends Config {
    BrowserType browser();
    @DefaultValue("15")
    Long timeout();
    @Key("takesscreenshot")
    boolean takesscreenshot();
    @Key("favtools")
    List<String> favtools();
    String author();

}
