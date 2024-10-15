package br.com.pdv.infrastructure.controllers.mappers;

import br.com.pdv.domain.entity.WebHook;
import br.com.pdv.infrastructure.controllers.request.WebHookRequest;

public class WebHookDTOMapper {

    public WebHook toWebHook(WebHookRequest webHookRequest){
        return new WebHook(webHookRequest.status(), webHookRequest.idOrder());
    }

}
