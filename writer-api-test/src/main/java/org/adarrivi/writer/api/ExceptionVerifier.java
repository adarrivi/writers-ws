package org.adarrivi.writer.api;

import org.junit.Assert;

public class ExceptionVerifier {

    public void verifyExceptionThrown(Class<? extends Exception> exceptionClass, MethodExecution execution) {
        try {
            execution.executeMethod();
            Assert.fail("No exception thrown");
        } catch (Exception ex) {
            Assert.assertEquals(exceptionClass, ex.getClass());
        }
    }

    public interface MethodExecution {
        void executeMethod();
    }
}
