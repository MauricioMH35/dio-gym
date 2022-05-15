package dio.gym.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnathorazedException extends RuntimeException {

    public UnathorazedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnathorazedException(String message) {
        super(message);
    }

    public UnathorazedException(Throwable cause) {
        super(cause);
    }

    public UnathorazedException() {

    }

}
