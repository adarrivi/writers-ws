package org.adarrivi.writer.ws.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

public class IntegrationTestHttpRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationTestHttpRequest.class);

    private MockMvc mockMvc;
    private ResultActions resultActions;

    public IntegrationTestHttpRequest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    public void performJsonGet(String url, JsonDto<?> dto) {
        try {
            resultActions = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON).content(dto.toJsonString()));
        } catch (Exception ex) {
            throw new AssertionError(ex);
        }
    }

    public void performGet(String url) {
        try {
            resultActions = mockMvc.perform(get(url));
        } catch (Exception ex) {
            throw new AssertionError(ex);
        }
    }

    public void performJsonPost(String url, JsonDto<?> dto) {
        try {
            resultActions = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(dto.toJsonString()));
        } catch (Exception ex) {
            throw new AssertionError(ex);
        }
    }

    public void assertHttpOkResponse() {
        try {
            resultActions.andExpect(status().isOk());
        } catch (Exception ex) {
            throw new AssertionError(ex);
        }
    }

    public void assertBadRequestResponse() {
        try {
            resultActions.andExpect(status().isBadRequest());
        } catch (Exception ex) {
            throw new AssertionError(ex);
        }
    }

    public void assertNotFoundResponse() {
        try {
            resultActions.andExpect(status().isNotFound());
        } catch (Exception ex) {
            throw new AssertionError(ex);
        }
    }

    public String getResponseAsString() {
        try {
            return resultActions.andReturn().getResponse().getContentAsString();
        } catch (Exception ex) {
            throw new AssertionError(ex);
        }
    }

    public <T extends Object> T getResponseAsJsonObject(Class<T> jsonObjectClass) {
        JsonDto<T> response = new JsonDto<T>(getResponseAsString(), jsonObjectClass);
        return response.toJsonObject();
    }

    public void logResponse() {
        LOGGER.debug("Response: {}", getResponseAsString());
    }
}
