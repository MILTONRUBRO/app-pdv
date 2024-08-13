package br.com.pdv.adapter.outbound.integration.repository;

import org.springframework.stereotype.Component;

import br.com.pdv.domain.Product;
import br.com.pdv.domain.ports.outbound.UpdateProductAdapterPort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class UpdateProductAdapter implements UpdateProductAdapterPort {

	@Override
	public void update(Product product, Long idProduct, Category category) {
		// TODO Auto-generated method stub
		mapper
		
		
	}

}
