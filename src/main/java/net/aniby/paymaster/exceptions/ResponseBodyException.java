package net.aniby.paymaster.exceptions;

import java.io.IOException;

public class ResponseBodyException extends IOException {
    public ResponseBodyException() {
        super();
    }

    public ResponseBodyException(String message) {
        super(message);
    }

    public ResponseBodyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResponseBodyException(Throwable cause) {
        super(cause);
    }

    public static ResponseBodyException NULL = new ResponseBodyException("Response body is null");
    public static ResponseBodyException EMPTY = new ResponseBodyException("Response body is empty");
}
