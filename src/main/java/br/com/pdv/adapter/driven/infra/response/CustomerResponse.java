package br.com.pdv.adapter.driven.infra.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private String name;
    private String email;
    private String document;
}
