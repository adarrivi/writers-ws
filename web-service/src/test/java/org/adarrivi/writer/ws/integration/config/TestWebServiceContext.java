package org.adarrivi.writer.ws.integration.config;

import org.adarrivi.writer.config.WebRestConfiguration;
import org.adarrivi.writer.config.WebServiceCoreContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = { WebRestConfiguration.class, WebServiceCoreContext.class })
public class TestWebServiceContext {

}
