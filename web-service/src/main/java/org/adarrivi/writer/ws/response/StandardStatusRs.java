package org.adarrivi.writer.ws.response;

public class StandardStatusRs {

	private ResponseStatus code;
	private String errorMessage;

	StandardStatusRs() {
		// Constructor required by json parsers
	}

	StandardStatusRs(ResponseStatus code, String errorMessage) {
		this.code = code;
		this.errorMessage = errorMessage;
	}

	public ResponseStatus getCode() {
		return code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
