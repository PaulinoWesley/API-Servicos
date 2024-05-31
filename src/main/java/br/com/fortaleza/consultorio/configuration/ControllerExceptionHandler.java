package br.com.fortaleza.consultorio.configuration;

import br.com.fortaleza.consultorio.dto.GlobalErrorResponseDTO;
import br.com.fortaleza.consultorio.exception.BadRequestException;
import br.com.fortaleza.consultorio.exception.BusinessException;
import br.com.fortaleza.consultorio.exception.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    private static final String JSON_EXCEPTION = "HttpMessageNotReadableException";

    @ExceptionHandler(value = {
            Exception.class
    })
    public ResponseEntity<GlobalErrorResponseDTO> globalExceptionHandler(Exception e, HandlerMethod handlerMethod, HttpServletRequest request) {
        GlobalErrorResponseDTO globalErrorResponse = getGlobalErrorResponse(e, handlerMethod, request, HttpStatus.INTERNAL_SERVER_ERROR);
        logger.error(globalErrorResponse.toString());
        globalErrorResponse.setError("Internal Server Error");
        globalErrorResponse.setMessage("Ocorreu um erro inesperado. Contate o administrador do sistema");
        return new ResponseEntity<>(globalErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {
            NotFoundException.class,
            NoSuchElementException.class
    })
    public ResponseEntity<GlobalErrorResponseDTO> notFoundExceptionHandler(Exception e, HandlerMethod handlerMethod, HttpServletRequest request) {
        GlobalErrorResponseDTO globalErrorResponse = getGlobalErrorResponse(e, handlerMethod, request, HttpStatus.NOT_FOUND);
        logger.error(globalErrorResponse.toString());
        return new ResponseEntity<>(globalErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {
            BadRequestException.class,
            SQLIntegrityConstraintViolationException.class,
            SQLException.class,
            BusinessException.class,
            HttpMessageNotReadableException.class
    })
    public ResponseEntity<GlobalErrorResponseDTO> badRequestExceptionHandler(Exception e, HandlerMethod handlerMethod, HttpServletRequest request) {
        GlobalErrorResponseDTO globalErrorResponse = getGlobalErrorResponse(e, handlerMethod, request, HttpStatus.BAD_REQUEST);
        logger.error(globalErrorResponse.toString());
        if (GlobalErrorResponseDTO.getClassName(e.getClass().toString()).equals(JSON_EXCEPTION))
            globalErrorResponse.setMessage("Payload contem um formato JSON inválido!");

        return new ResponseEntity<>(globalErrorResponse, HttpStatus.BAD_REQUEST);
    }

    private GlobalErrorResponseDTO getGlobalErrorResponse(Exception exception, HandlerMethod handlerMethod, HttpServletRequest request, HttpStatus httpStatus) {
        return new GlobalErrorResponseDTO(
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                request.getMethod(),
                request.getRequestURL().toString(),
                handlerMethod.getMethod().getDeclaringClass().toString(),
                handlerMethod.getMethod().getName(),
                exception
        );
    }

}
