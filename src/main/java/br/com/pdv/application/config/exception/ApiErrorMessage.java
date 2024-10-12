package br.com.pdv.application.config.exception;

import lombok.Data;

@Data
public class ApiErrorMessage {
    private String message;
    private int status;
    private String timestamp;
    private String path;

}
