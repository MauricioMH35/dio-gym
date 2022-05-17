package dio.gym.handlers;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        // Setting HttpStatus if Null
        final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        // Payload with exception details
        ApiException apiException = new ApiException(
                e.getMessage(), httpStatus, httpStatus.value(), ZonedDateTime.now(ZoneId.of("Z"))
        );

        // Return response entity
        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(value = {ConflictException.class})
    public ResponseEntity<Object> handleConflictException(ConflictException e) {
        final HttpStatus httpStatus = HttpStatus.CONFLICT;
        ApiException apiException = new ApiException(
                e.getMessage(), httpStatus, httpStatus.value(), ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(value = {UnathorazedException.class})
    public ResponseEntity<Object> handleUnathorazedException(UnathorazedException e) {
        final HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
        ApiException apiException = new ApiException(
                e.getMessage(), httpStatus, httpStatus.value(), ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, httpStatus);
    }

}
