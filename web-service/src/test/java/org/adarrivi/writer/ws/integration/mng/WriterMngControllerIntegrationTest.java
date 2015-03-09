package org.adarrivi.writer.ws.integration.mng;

import org.adarrivi.writer.api.mng.Writer;
import org.adarrivi.writer.api.mng.TestWriterFactory;
import org.adarrivi.writer.ws.integration.GenericWebIntegrationTest;
import org.adarrivi.writer.ws.integration.JsonDto;
import org.adarrivi.writer.ws.integration.TestMngRequestFactory;
import org.adarrivi.writer.ws.mng.WriterDetailsRs;
import org.adarrivi.writer.ws.mng.WriterJson;
import org.adarrivi.writer.ws.response.BasicRs;
import org.adarrivi.writer.ws.response.ResponseStatus;
import org.junit.Assert;
import org.junit.Test;

public class WriterMngControllerIntegrationTest extends GenericWebIntegrationTest {

    private static final String CONTROLLER_URL = "/writers";

    @Test
    public void create_ReturnsRestfulOkStatus() {
        whenCreateWriter(TestWriterFactory.createHerbert());
        getIntegrationTestHttpRequest().logResponse();
        getIntegrationTestHttpRequest().assertHttpOkResponse();
        BasicRs response = getIntegrationTestHttpRequest().getResponseAsJsonObject(BasicRs.class);
        Assert.assertTrue(ResponseStatus.OK.equals(response.getStatus().getCode()));
    }

    private void whenCreateWriter(Writer writer) {
        JsonDto<WriterJson> newWriterRequest = new JsonDto<>(TestMngRequestFactory.createNewWriterRq(writer));
        getIntegrationTestHttpRequest().performJsonPost(CONTROLLER_URL, newWriterRequest);
    }

    @Test
    public void createAndDetails_ReturnsDetails() {
        Writer writer = TestWriterFactory.createHerbert();
        whenCreateWriter(writer);
        whenGetDetails(writer.getPseudonym());
        getIntegrationTestHttpRequest().logResponse();
        WriterDetailsRs response = getIntegrationTestHttpRequest().getResponseAsJsonObject(WriterDetailsRs.class);
        Assert.assertEquals(writer.getAlterEgo(), response.getWriter().getName());
    }

    private void whenGetDetails(String pseudonym) {
        getIntegrationTestHttpRequest().performGet(CONTROLLER_URL + "/" + pseudonym);
    }
}
