package br.com.pdv.adapter.driven.infra.dto.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private String name;
    private String email;
    private String document;
}
