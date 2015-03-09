package org.adarrivi.writer.ws.mng;

import org.adarrivi.writer.ws.response.BasicRs;

public class WriterDetailsRs extends BasicRs {

    private WriterJson writer;

    WriterDetailsRs() {
        // Needed by Json parser
    }

    public WriterDetailsRs(String errorMessage) {
        super(errorMessage);
    }

    WriterDetailsRs(WriterJson writer) {
        this.writer = writer;
    }

    public WriterJson getWriter() {
        return writer;
    }

}
