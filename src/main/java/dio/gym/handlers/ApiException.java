package dio.gym.handlers;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {

    private final String message;
    private final HttpStatus httpStatus;
    private final int statusCode;
    private final ZonedDateTime timeZone;

    public ApiException(String message, HttpStatus httpStatus, int statusCode, ZonedDateTime timeZone) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.statusCode = statusCode;
        this.timeZone = timeZone;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public ZonedDateTime getTimeZone() {
        return timeZone;
    }

}
