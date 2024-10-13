package br.com.pdv.main;

import br.com.pdv.infrastructure.controllers.mappers.OrderDTOMapper;
import br.com.pdv.infrastructure.controllers.mappers.WebHookDTOMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebHookConfig {

    @Bean
    WebHookDTOMapper webHookDTOMapper() {
        return new WebHookDTOMapper();
    }
}
