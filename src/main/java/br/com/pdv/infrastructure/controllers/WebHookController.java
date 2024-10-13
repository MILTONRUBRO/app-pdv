package br.com.pdv.infrastructure.controllers;

import br.com.pdv.domain.entity.WebHook;
import br.com.pdv.infrastructure.controllers.mappers.WebHookDTOMapper;
import br.com.pdv.infrastructure.controllers.request.WebHookRequest;
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

    public WebHookController(WebHookDTOMapper webHookDTOMapper) {
        this.webHookDTOMapper = webHookDTOMapper;
    }

    @PostMapping
    public ResponseEntity<Void> saveProduct(@RequestBody WebHookRequest request) {
        log.info("POST Webhook received Request: {}", request);
        WebHook webHook = webHookDTOMapper.toWebHook(request);
        //Product product = createProductUseCase.createProduct(productBusinessObj);
        return ResponseEntity.noContent().build();
    }
}
