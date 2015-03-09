package org.adarrivi.writer.api.mng;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.adarrivi.writer.api.exception.WriterException;
import org.springframework.stereotype.Service;

@Service
class WriterMngServiceInMemoryImpl implements WriterMngApiService {

    private ConcurrentHashMap<String, Writer> writerRepository = new ConcurrentHashMap<>();

    WriterMngServiceInMemoryImpl() {
        // To enforce the use of DI
    }

    @Override
    public void createNewWriter(NewWriterApiRq request) {
        Writer writer = toWriter(request);
        Writer previousWriter = writerRepository.putIfAbsent(writer.getPseudonym(), writer);
        if (previousWriter != null) {
            throw new WriterException("The writer " + writer.getPseudonym() + " already exists");
        }
    }

    private Writer toWriter(NewWriterApiRq request) {
        return new Writer(request.getFullName(), request.getPseudonym(), request.getAllies(), request.getPublisher(), request.getSkills(),
                request.getFirstAppearance());
    }

    @Override
    public Optional<Writer> getWriter(String pseudonym) {
        return Optional.ofNullable(writerRepository.get(pseudonym));
    }

    @Override
    public Collection<Writer> getAll() {
        return writerRepository.values();
    }
}
