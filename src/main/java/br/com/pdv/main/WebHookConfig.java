package br.com.pdv.main;

import br.com.pdv.application.gateways.OrderGateway;
import br.com.pdv.application.usecase.UpdateOrderPaymentsInteractor;
import br.com.pdv.infrastructure.controllers.mappers.WebHookDTOMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebHookConfig {

    @Bean
    WebHookDTOMapper webHookDTOMapper() {
        return new WebHookDTOMapper();
    }

    @Bean
    UpdateOrderPaymentsInteractor updateOrderPaymentsInteractor(OrderGateway orderGateway) {
        return new UpdateOrderPaymentsInteractor(orderGateway);
    }


}
