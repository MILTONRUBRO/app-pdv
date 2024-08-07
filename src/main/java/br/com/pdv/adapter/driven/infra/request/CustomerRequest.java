package br.com.pdv.adapter.driven.infra.request;

import lombok.Data;

@Data
public class CustomerRequest {
    private String name;
    private String email;
    private String document;
}
