package org.adarrivi.writer.ws.functional;

import org.adarrivi.writer.api.mng.TestWriterFactory;
import org.adarrivi.writer.ws.integration.JsonDto;
import org.adarrivi.writer.ws.integration.TestMngRequestFactory;
import org.adarrivi.writer.ws.mng.ListAllWriterRs;
import org.adarrivi.writer.ws.mng.WriterDetailsRs;
import org.adarrivi.writer.ws.mng.WriterJson;
import org.adarrivi.writer.ws.response.BasicRs;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class RemoteFunctionalTest {

    private static final String SPIDER_MAN = "Spider-Man";

    private static final String REST_URL = "http://ec2-54-93-88-69.eu-central-1.compute.amazonaws.com:8080/writerws/writers";

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void createDetailsList() {
        createWriter();
        getWriterDetails();
        listWriters();
    }

    private void createWriter() {
        JsonDto<WriterJson> newWriterRequest = createNewJsonRequest();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(newWriterRequest.toJsonString(), headers);
        restTemplate.exchange(REST_URL, HttpMethod.POST, entity, BasicRs.class);
    }

    private JsonDto<WriterJson> createNewJsonRequest() {
        return new JsonDto<>(TestMngRequestFactory.createNewWriterRq(TestWriterFactory.createHerbert()));
    }

    private void getWriterDetails() {
        WriterDetailsRs writerDetails = restTemplate.getForObject(REST_URL + "/" + SPIDER_MAN, WriterDetailsRs.class);
        Assert.assertEquals(SPIDER_MAN, writerDetails.getWriter().getPseudonym());
    }

    private void listWriters() {
        ListAllWriterRs allWriters = restTemplate.getForObject(REST_URL, ListAllWriterRs.class);
        Assert.assertFalse(allWriters.getWriters().isEmpty());
    }

}
