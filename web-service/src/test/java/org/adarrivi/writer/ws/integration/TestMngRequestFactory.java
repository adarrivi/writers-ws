package org.adarrivi.writer.ws.integration;

import org.adarrivi.writer.api.mng.Writer;
import org.adarrivi.writer.ws.mng.WriterJson;

public class TestMngRequestFactory {

    public static WriterJson createNewWriterRq(Writer writer) {
        return new WriterJson(writer.getAlterEgo(), writer.getPseudonym(), writer.getAllies(), writer.getPublisher(),
                writer.getSkills(), writer.getFirstAppearance());
    }

}
