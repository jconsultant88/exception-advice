package net.ruvetech.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = Logger.getLogger(GlobalExceptionHandler.class);

    public GlobalExceptionHandler() {
        LOG.info("GlobalExceptionHandler created");
    }

    @ExceptionHandler(RestException.class)
    @ResponseBody
    public final ResponseEntity<RestError> handleRestException(final RestException ex, final HttpServletRequest httpRequest,
                                                               final HttpServletResponse httpResponse) {
        LOG.info("mapping rest exception to rest error");
        RestError restError = new RestError(ex.getErrorCode(), ex.getMessage());
        return new ResponseEntity<RestError>(restError, HttpStatus.BAD_REQUEST);
    }

}
