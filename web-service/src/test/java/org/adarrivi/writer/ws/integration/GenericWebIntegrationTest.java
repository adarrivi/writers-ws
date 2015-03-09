package org.adarrivi.writer.ws.integration;

import org.adarrivi.writer.ws.integration.config.TestWebServiceContext;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestWebServiceContext.class })
public abstract class GenericWebIntegrationTest {

	@Autowired
	private WebApplicationContext context;
	private IntegrationTestHttpRequest integrationTestHttpRequest;

	@Before
	public void setUp() {
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		integrationTestHttpRequest = new IntegrationTestHttpRequest(mockMvc);
	}

	protected IntegrationTestHttpRequest getIntegrationTestHttpRequest() {
		return integrationTestHttpRequest;
	}

}
