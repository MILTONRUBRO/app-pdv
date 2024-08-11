package br.com.pdv.adapter.driven.infra.response;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private int status;
    private String timestamp;
    private String path;

}
