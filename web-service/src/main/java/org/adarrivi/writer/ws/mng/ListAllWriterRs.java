package org.adarrivi.writer.ws.mng;

import java.util.Collection;

import org.adarrivi.writer.ws.response.BasicRs;

public class ListAllWriterRs extends BasicRs {

    private Collection<WriterJson> writers;

    ListAllWriterRs() {
        // Needed by json parser
    }

    public ListAllWriterRs(String errorMessage) {
        super(errorMessage);
        // TODO Auto-generated constructor stub
    }

    ListAllWriterRs(Collection<WriterJson> writers) {
        this.writers = writers;
    }

    public Collection<WriterJson> getWriters() {
        return writers;
    }

}
