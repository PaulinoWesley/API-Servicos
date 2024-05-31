package br.com.fortaleza.consultorio.exception;

import java.io.Serial;

public class NotFoundException extends Exception {
    @Serial
    private static final long serialVersionUID = -4325451173845539322L;
    public NotFoundException() {}
    public NotFoundException(String message) { super(message); }
    public NotFoundException(Throwable cause) { super(cause); }
    public NotFoundException(String message, Throwable cause) { super(message, cause); }
}
