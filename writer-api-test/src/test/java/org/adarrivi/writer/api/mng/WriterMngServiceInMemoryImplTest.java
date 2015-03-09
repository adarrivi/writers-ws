package org.adarrivi.writer.api.mng;

import org.adarrivi.writer.api.ExceptionVerifier;
import org.adarrivi.writer.api.exception.WriterException;
import org.adarrivi.writer.api.mng.NewWriterApiRq;
import org.adarrivi.writer.api.mng.Writer;
import org.adarrivi.writer.api.mng.WriterMngApiService;
import org.adarrivi.writer.api.mng.WriterMngServiceInMemoryImpl;
import org.adarrivi.writer.api.mng.TestWriterFactory;
import org.junit.Before;
import org.junit.Test;

public class WriterMngServiceInMemoryImplTest {

    private WriterMngApiService victim;

    private NewWriterApiRq inputRequest;

    private ExceptionVerifier exceptionVerifier = new ExceptionVerifier();

    @Before
    public void setUp() {
        // Required to reset the in-memory map
        victim = new WriterMngServiceInMemoryImpl();
    }

    @Test
    public void create_TwiceSameWriter_ThrowsEx() {
        givenCreateRequest(TestWriterFactory.createHerbert());
        whenCreate();
        exceptionVerifier.verifyExceptionThrown(WriterException.class, () -> whenCreate());
    }

    private void givenCreateRequest(Writer writer) {
        inputRequest = TestWriterFactory.createNewWriterApiRq(writer);
    }

    private void whenCreate() {
        victim.createNewWriter(inputRequest);
    }

}
