package org.adarrivi.writer.api.mng;

import java.util.Collection;
import java.util.Optional;

public interface WriterMngApiService {

    void createNewWriter(NewWriterApiRq request);

    Optional<Writer> getWriter(String pseudonym);

    Collection<Writer> getAll();
}
