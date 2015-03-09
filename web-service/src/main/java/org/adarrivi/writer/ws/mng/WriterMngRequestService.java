package org.adarrivi.writer.ws.mng;

import org.adarrivi.writer.ws.response.BasicRs;

public interface WriterMngRequestService {

    ListAllWriterRs getAll();

    WriterDetailsRs getDetails(String pseudonym);

    BasicRs createWriter(WriterJson writer);

}
