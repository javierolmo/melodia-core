package com.javi.uned.melodiacore.exceptions.runtime;

public class MelodiaRuntimeException extends RuntimeException {

    public MelodiaRuntimeException() {
    }

    public MelodiaRuntimeException(String message) {
        super(message);
    }

    public MelodiaRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MelodiaRuntimeException(Throwable cause) {
        super(cause);
    }
}
