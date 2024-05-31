package br.com.fortaleza.consultorio.exception;


import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

import java.io.Serial;

public class InvalidJwtAuthenticationException extends AuthenticationException {
    @Serial
    private static final long serialVersionUID = -4425723786424281386L;
    public static final HttpStatus HTTP_STATUS = HttpStatus.FORBIDDEN;
    public static final String INVALID_JWT_ERROR = "Expired or invalid JWT Token";
    public InvalidJwtAuthenticationException() { super(INVALID_JWT_ERROR); }
    public InvalidJwtAuthenticationException(String message) { super(INVALID_JWT_ERROR.concat(message)); }
    public InvalidJwtAuthenticationException(Throwable cause) { super(cause.getMessage(), cause); }
    public InvalidJwtAuthenticationException(String message, Throwable cause) { super(INVALID_JWT_ERROR.concat(message), cause); }
}
