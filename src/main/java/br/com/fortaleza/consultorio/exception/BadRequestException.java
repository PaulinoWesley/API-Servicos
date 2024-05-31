package br.com.fortaleza.consultorio.exception;

import java.io.Serial;

public class BadRequestException extends Exception {
    @Serial
    private static final long serialVersionUID = -8860662395692980713L;
    public BadRequestException() {}
    public BadRequestException(String message) { super(message); }
    public BadRequestException(Throwable cause) { super(cause); }
    public BadRequestException(String message, Throwable cause) { super(message, cause); }
}
