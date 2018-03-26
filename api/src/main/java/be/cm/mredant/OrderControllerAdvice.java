package be.cm.mredant;

import be.cm.mredant.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice(basePackages = {"be.cm.mredant"})
@RestController
@RequestMapping(produces = "application/vnd.error+json")
public class OrderControllerAdvice extends ResponseEntityExceptionHandler {

    //http://www.springboottutorial.com/spring-boot-exception-handling-for-rest-services

    @ExceptionHandler(EntryAlreadyExistsInDatabaseException.class)
    public final ResponseEntity<ErrorDetails> convertUnknownIdException(EntryAlreadyExistsInDatabaseException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                request.getDescription(false));
        logger.error(errorDetails);
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnKnownFieldFoundException.class)
    public final ResponseEntity<ErrorDetails> convertIllegalFieldFoundException(UnKnownFieldFoundException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                request.getDescription(false));
        logger.error(errorDetails);
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnknownResourceException.class)
    public final ResponseEntity<ErrorDetails> convertIllegalFieldFoundException(UnknownResourceException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                request.getDescription(false));
        logger.error(errorDetails);
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OutOfStockEception.class)
    public final ResponseEntity<ErrorDetails> convertIllegalFieldFoundException(OutOfStockEception exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                request.getDescription(false));
        logger.error(errorDetails);
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }

    //handles all other exceptions
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                request.getDescription(false));
        logger.error(errorDetails);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
