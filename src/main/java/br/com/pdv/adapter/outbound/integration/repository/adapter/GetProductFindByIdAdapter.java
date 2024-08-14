package br.com.pdv.adapter.outbound.integration.repository.adapter;

import org.springframework.stereotype.Component;

import br.com.pdv.adapter.inbound.controller.mapper.ProductMapper;
import br.com.pdv.adapter.outbound.integration.repository.ProductRepository;
import br.com.pdv.adapter.outbound.integration.repository.entity.ProductEntity;
import br.com.pdv.config.exception.NotFoundException;
import br.com.pdv.domain.Product;
import br.com.pdv.domain.ports.outbound.GetProductFindbyIdAdapterPort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class GetProductFindByIdAdapter implements GetProductFindbyIdAdapterPort {

	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	
	@Override
	public Product getProductById(Long id) {
		 ProductEntity productEntity = productRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Produto Não Encontrado"));
	
		 return productMapper.entityToProduct(productEntity);
	}

}
