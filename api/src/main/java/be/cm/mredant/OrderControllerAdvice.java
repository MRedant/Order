package be.cm.mredant;

import be.cm.mredant.exceptions.EntryAlreadyExistsInDatabaseException;
import be.cm.mredant.exceptions.UnKnownFieldFoundException;
import be.cm.mredant.exceptions.UnknownResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = {"be.cm.mredant"})
public class OrderControllerAdvice {

    @ExceptionHandler(EntryAlreadyExistsInDatabaseException.class)
    public ResponseEntity<String> convertUnknownIdException(final EntryAlreadyExistsInDatabaseException exception) {
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnKnownFieldFoundException.class)
    public ResponseEntity<String> convertIllegalFieldFoundException(final UnKnownFieldFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnknownResourceException.class)
    public ResponseEntity<String> convertIllegalFieldFoundException(final UnknownResourceException exception) {
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
