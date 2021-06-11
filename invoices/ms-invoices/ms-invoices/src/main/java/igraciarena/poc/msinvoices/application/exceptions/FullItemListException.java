package igraciarena.poc.msinvoices.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class FullItemListException extends Throwable {
    private String message;

    public FullItemListException() {
    }

    public FullItemListException(String message) {
        this.message = message;
    }
}


