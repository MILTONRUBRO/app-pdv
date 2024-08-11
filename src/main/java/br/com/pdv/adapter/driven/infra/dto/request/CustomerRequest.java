package br.com.pdv.adapter.driven.infra.dto.request;

import lombok.Data;

@Data
public class CustomerRequest {
    private String name;
    private String email;
    private String document;
}
