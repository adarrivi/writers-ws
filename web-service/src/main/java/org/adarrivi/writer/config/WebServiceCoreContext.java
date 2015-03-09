package org.adarrivi.writer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = { ApiContext.class })
@ComponentScan(basePackages = { WebServiceCoreContext.SERVICE_PACKAGE })
public class WebServiceCoreContext {

    static final String SERVICE_PACKAGE = "org.adarrivi.writer.ws";
}
