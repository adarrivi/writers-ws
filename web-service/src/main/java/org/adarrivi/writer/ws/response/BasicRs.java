package org.adarrivi.writer.ws.response;

public class BasicRs {

	private StandardStatusRs status;

	public BasicRs() {
		// Needed by Json parser
		this.status = new StandardStatusRs(ResponseStatus.OK, null);
	}

	public BasicRs(String errorMessage) {
		this.status = new StandardStatusRs(ResponseStatus.ERR, errorMessage);
	}

	public static BasicRs createErrorResponse(String errorMessage) {
		return new BasicRs(errorMessage);
	}

	public static BasicRs createOkResponse() {
		return new BasicRs();
	}

	public StandardStatusRs getStatus() {
		return status;
	}

}
