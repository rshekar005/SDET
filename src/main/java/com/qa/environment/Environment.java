package com.qa.environment;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(
        {"system:properties",
                "system:env",
                "file:${user.dir}/src/test/resources/config.properties",
                "file:${user.dir}/src/test/resources/dev.properties",
                "file:${user.dir}/src/test/resources/staging.properties",})
public interface Environment extends Config {

    @Config.Key("browser")
    String browser();

    @Config.Key("environment")
    String environment();

    @Config.Key("${environment}-username")
    String username();

    @Config.Key("${environment}-url")
    String url();
}
