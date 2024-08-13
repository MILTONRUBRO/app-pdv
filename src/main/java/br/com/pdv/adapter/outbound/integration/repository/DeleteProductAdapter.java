package br.com.pdv.adapter.outbound.integration.repository;

import org.springframework.stereotype.Component;

import br.com.pdv.config.exception.NotFoundException;
import br.com.pdv.domain.ports.outbound.DeleteProductAdapterPort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class DeleteProductAdapter implements DeleteProductAdapterPort {
	
	private final ProductRepository productRepository;

	@Override
	public void delete(Long id) {
		var product = productRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Produto Não Encontrado"));
		
		productRepository.delete(product);
	}

}
