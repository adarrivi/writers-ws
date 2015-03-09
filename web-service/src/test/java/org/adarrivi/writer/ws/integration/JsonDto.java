package org.adarrivi.writer.ws.integration;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDto<T> {

	private T dto;
	private String dtoAsString;
	private Class<T> dtoClass;
	private ObjectMapper jsonMapper = new ObjectMapper();

	@SuppressWarnings("unchecked")
	public JsonDto(T dto) {
		this.dto = dto;
		this.dtoClass = (Class<T>) dto.getClass();
	}

	public JsonDto(String dtoAsString, Class<T> dtoClass) {
		this.dtoAsString = dtoAsString;
		this.dtoClass = dtoClass;
	}

	public String toJsonString() {
		if (dtoAsString == null) {
			try {
				dtoAsString = jsonMapper.writeValueAsString(dto);
			} catch (IOException ex) {
				throw new AssertionError("Could not parse object into json string: ", ex);
			}
		}
		return dtoAsString;
	}

	public T toJsonObject() {
		if (dto == null) {
			try {
				dto = jsonMapper.readValue(dtoAsString, dtoClass);
				return dto;
			} catch (IOException ex) {
				throw new AssertionError("Could not parse back string into json object: ", ex);
			}
		}
		return dto;
	}
}
