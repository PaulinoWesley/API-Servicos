package br.com.fortaleza.consultorio.dto;

import br.com.fortaleza.consultorio.util.DateUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

@Getter
@Setter
public class GlobalErrorResponseDTO {
    private String error;
    private String message;
    private int status;
    private String timestamp;
    @JsonIgnore
    private String method;
    @JsonIgnore
    private String path;
    @JsonIgnore
    private String controllerName;
    @JsonIgnore
    private String methodName;
    @JsonIgnore
    private String controllerPath;
    @JsonIgnore
    private String exceptionClassName;
    @JsonIgnore
    private String exceptionStackTrace;

    public GlobalErrorResponseDTO(int status, String error, String method, String path, String controllerPath, String methodName, Exception e) {
        this.status = status;
        this.error = error;
        this.method = method;
        this.path = path;
        this.controllerPath = controllerPath;
        this.controllerName = getClassName(controllerPath);
        this.methodName = methodName;
        this.timestamp = DateUtils.parseDateToLongBr(LocalDateTime.now());
        this.message = e.getMessage();
        this.exceptionClassName = getClassName(e.getClass().toString());
        this.exceptionStackTrace =e.getStackTrace()[0].toString();
    }

    @Override
    public String toString() {
        return "\nError occurred in " + controllerName + ".\n" +
                "Error data: \n" +
                "   Status: " + status + ". \n" +
                "   Error: " + error + ". \n" +
                "   Method: " + method + ". \n" +
                "   Path URL: " + path + ". \n" +
                "   Message: " + message + " \n" +
                "   Timestamp: " + timestamp + ". \n" +
                "   Service: " + methodName + ". \n" +
                "   Controller path: " + controllerPath + ". \n" +
                "   Exception: " + exceptionClassName + ". \n" +
                "   Exception short stack trace: " + exceptionStackTrace + ". \n";
    }

    public static String getClassName(String controllerPath) {
        return StringUtils.substringAfterLast(controllerPath, ".");
    }

}
