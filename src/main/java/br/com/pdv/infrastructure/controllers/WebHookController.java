package br.com.pdv.infrastructure.controllers;

import br.com.pdv.application.usecase.UpdateOrderPaymentsInteractor;
import br.com.pdv.application.usecase.UpdateOrderStatusInteractor;
import br.com.pdv.domain.entity.WebHook;
import br.com.pdv.infrastructure.controllers.mappers.WebHookDTOMapper;
import br.com.pdv.infrastructure.controllers.request.WebHookRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/webhook")
public class WebHookController {

    private final WebHookDTOMapper webHookDTOMapper;
    private final UpdateOrderPaymentsInteractor updateOrderPayments;

    public WebHookController(WebHookDTOMapper webHookDTOMapper,
                             UpdateOrderPaymentsInteractor updateOrderPayments) {
		this.webHookDTOMapper = webHookDTOMapper;
		this.updateOrderPayments = updateOrderPayments;
	}



    @Operation(summary = "Receive Webhook Request",
            description = "Handles incoming webhook requests to update the order status.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Webhook processed successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            })
	@PostMapping
    public ResponseEntity<Void> saveProduct(@RequestBody WebHookRequest request) {
        log.info("POST Webhook received Request: {}", request);
        WebHook webHook = webHookDTOMapper.toWebHook(request);
        updateOrderPayments.updateOrderPayments(webHook.idOrder(), webHook.status());

        return ResponseEntity.noContent().build();
    }
}
