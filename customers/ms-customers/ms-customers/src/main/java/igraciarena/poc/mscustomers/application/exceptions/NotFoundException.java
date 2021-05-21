package igraciarena.poc.mscustomers.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private String message;

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        this.message = message;
    }
}
