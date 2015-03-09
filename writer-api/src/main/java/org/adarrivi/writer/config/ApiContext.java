package org.adarrivi.writer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { ApiContext.SERVICE_PACKAGE })
public class ApiContext {

    static final String SERVICE_PACKAGE = "org.adarrivi.writer.api";

}
