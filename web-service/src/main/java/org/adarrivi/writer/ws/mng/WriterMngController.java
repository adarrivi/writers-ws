package org.adarrivi.writer.ws.mng;

import org.adarrivi.writer.ws.response.BasicRs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WriterMngController {

    @Autowired
    private WriterMngRequestService writerMngRequestService;

    @RequestMapping(value = "/writers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ListAllWriterRs listAll() {
        return writerMngRequestService.getAll();
    }

    @RequestMapping(value = "/writers/{pseudonym}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public WriterDetailsRs getWriter(@PathVariable("pseudonym") String pseudonym) {
        return writerMngRequestService.getDetails(pseudonym);
    }

    @RequestMapping(value = "/writers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BasicRs createWriter(@RequestBody WriterJson newWriter) {
        return writerMngRequestService.createWriter(newWriter);
    }

}
