package br.com.pdv.config;

import br.com.pdv.adapter.outbound.integration.repository.GetCustomerByDocumentAdapter;
import br.com.pdv.adapter.outbound.integration.repository.PostCustomerAdapter;
import br.com.pdv.domain.ports.inbound.GetCustomerByDocumentUseCasePort;
import br.com.pdv.domain.ports.inbound.PostCustomerUseCasePort;
import br.com.pdv.domain.usecase.GetCustomerByDocumentUseCase;
import br.com.pdv.domain.usecase.PostCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public GetCustomerByDocumentUseCasePort getCustomerByDocumentUseCasePort(GetCustomerByDocumentAdapter getCustomerByDocumentAdapter) {
        return new GetCustomerByDocumentUseCase(getCustomerByDocumentAdapter);
    }

    @Bean
    public PostCustomerUseCasePort postCustomerServiceUseCasePort(PostCustomerAdapter postCustomerAdapter) {
        return new PostCustomerUseCase(postCustomerAdapter);
    }

}
