package org.adarrivi.writer.ws.mng;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.adarrivi.writer.api.exception.WriterException;
import org.adarrivi.writer.api.mng.NewWriterApiRq;
import org.adarrivi.writer.api.mng.Writer;
import org.adarrivi.writer.api.mng.WriterMngApiService;
import org.adarrivi.writer.ws.response.BasicRs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class WriterMngRequestServiceImpl implements WriterMngRequestService {

    @Autowired
    private WriterMngApiService writerMngApiService;

    WriterMngRequestServiceImpl() {
        // To enforce DI
    }

    @Override
    public ListAllWriterRs getAll() {
        List<WriterJson> allWriters = writerMngApiService.getAll().stream().map(this::toWriterJson)
                .collect(Collectors.toList());
        return new ListAllWriterRs(allWriters);
    }

    private WriterJson toWriterJson(Writer writer) {
        return new WriterJson(writer.getAlterEgo(), writer.getPseudonym(), writer.getAllies(), writer.getPublisher(),
                writer.getSkills(), writer.getFirstAppearance());
    }

    @Override
    public WriterDetailsRs getDetails(String pseudonym) {
        Optional<Writer> writer = writerMngApiService.getWriter(pseudonym);
        if (writer.isPresent()) {
            return new WriterDetailsRs(toWriterJson(writer.get()));
        }
        throw new WriterException("Writer " + pseudonym + " not found");
    }

    @Override
    public BasicRs createWriter(WriterJson writer) {
        writerMngApiService.createNewWriter(toNewWriterRq(writer));
        return new BasicRs();
    }

    private NewWriterApiRq toNewWriterRq(WriterJson writer) {
        return new NewWriterApiRq(writer.getName(), writer.getPseudonym(), writer.getAllies(), writer.getPublisher(),
                writer.getSkills(), writer.getFirstAppearance());
    }

}
