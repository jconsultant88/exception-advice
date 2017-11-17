package net.ruvetech.rest;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.ruvetech.exception.RestException;

@Controller
public class RestController {
    private static final Logger LOG = Logger.getLogger(RestController.class);
    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void echo(@RequestParam(value = "clientVersion", required = false) String clientVersion,
                     @RequestParam(value = "applicationName", required = false) String applicationName,
                     HttpServletRequest httpRequest) {
        LOG.info("Throwing exception...");
        throw new RestException("9999", "Invoke Exception Handler");
    }

}
