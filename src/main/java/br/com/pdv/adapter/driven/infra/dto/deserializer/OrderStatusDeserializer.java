package br.com.pdv.adapter.driven.infra.dto.deserializer;

import br.com.pdv.adapter.driven.infra.entity.OrderStatus;
import br.com.pdv.core.applications.exceptions.InvalidEnumValueException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class OrderStatusDeserializer extends JsonDeserializer<OrderStatus> {

    @Override
    public OrderStatus deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        String value = p.getText();
        try {
            return OrderStatus.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidEnumValueException("Invalid status value: " + value);
        }
    }
}