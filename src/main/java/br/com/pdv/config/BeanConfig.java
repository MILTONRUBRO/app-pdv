package br.com.pdv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.pdv.adapter.outbound.integration.repository.adapter.DeleteProductAdapter;
import br.com.pdv.adapter.outbound.integration.repository.adapter.GetCategoryByIDAdapter;
import br.com.pdv.adapter.outbound.integration.repository.adapter.GetCustomerByDocumentAdapter;
import br.com.pdv.adapter.outbound.integration.repository.adapter.GetListCategoryProductAdapter;
import br.com.pdv.adapter.outbound.integration.repository.adapter.GetProductFindByIdAdapter;
import br.com.pdv.adapter.outbound.integration.repository.adapter.ItemOrderCustomerAdapter;
import br.com.pdv.adapter.outbound.integration.repository.adapter.PatchOrderAdapter;
import br.com.pdv.adapter.outbound.integration.repository.adapter.PostCustomerAdapter;
import br.com.pdv.adapter.outbound.integration.repository.adapter.PostOrderAdapter;
import br.com.pdv.adapter.outbound.integration.repository.adapter.PostProductAdapter;
import br.com.pdv.adapter.outbound.integration.repository.adapter.UpdateProductAdapter;
import br.com.pdv.domain.ports.inbound.DeleteProductUseCasePort;
import br.com.pdv.domain.ports.inbound.GetCategoryByIDUseCasePort;
import br.com.pdv.domain.ports.inbound.GetCustomerByDocumentUseCasePort;
import br.com.pdv.domain.ports.inbound.GetListCategoryProductUseCasePort;
import br.com.pdv.domain.ports.inbound.GetProductFindbyIdUseCasePort;
import br.com.pdv.domain.ports.inbound.PatchOrderUseCasePort;
import br.com.pdv.domain.ports.inbound.PostCustomerUseCasePort;
import br.com.pdv.domain.ports.inbound.PostItemOrderUseCasePort;
import br.com.pdv.domain.ports.inbound.PostOrderUseCasePort;
import br.com.pdv.domain.ports.inbound.PostProductUseCasePort;
import br.com.pdv.domain.ports.inbound.UpdateProductUseCasePort;
import br.com.pdv.domain.usecase.DeleteProductUseCase;
import br.com.pdv.domain.usecase.GetCategoryByIdUseCase;
import br.com.pdv.domain.usecase.GetCustomerByDocumentUseCase;
import br.com.pdv.domain.usecase.GetListCategoryProductUseCase;
import br.com.pdv.domain.usecase.GetProductFindByIdUseCase;
import br.com.pdv.domain.usecase.PatchOrderUseCase;
import br.com.pdv.domain.usecase.PostCustomerUseCase;
import br.com.pdv.domain.usecase.PostItemOrderUseCase;
import br.com.pdv.domain.usecase.PostOrderUseCase;
import br.com.pdv.domain.usecase.PostProductUseCase;
import br.com.pdv.domain.usecase.UpdateProductUseCase;

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
    
    @Bean
    public DeleteProductUseCasePort deleteProductUseCasePort(DeleteProductAdapter deleteProductAdapter) {
    	return new DeleteProductUseCase(deleteProductAdapter);
    }
    
    @Bean
    public GetCategoryByIDUseCasePort  getCategoryByIDUseCasePort(GetCategoryByIDAdapter getCategoryByIDAdapter ) {
    	return new GetCategoryByIdUseCase(getCategoryByIDAdapter);
    }
    
    @Bean
    public GetListCategoryProductUseCasePort getListCategoryProductUseCasePort(GetListCategoryProductAdapter getListCategoryProductAdapter) {
    	return new GetListCategoryProductUseCase(getListCategoryProductAdapter);
    }
    
    @Bean
    public GetProductFindbyIdUseCasePort getProductFindbyIdUseCasePort(GetProductFindByIdAdapter getProductFindByIdAdapter) {
    	return new GetProductFindByIdUseCase(getProductFindByIdAdapter);
    }
    
    @Bean
    public PatchOrderUseCasePort patchOrderUseCasePort(PatchOrderAdapter patchOrderAdapter) {
    	return new PatchOrderUseCase(patchOrderAdapter);
    }
    
    @Bean
    public PostOrderUseCasePort postOrderUseCasePort(PostOrderAdapter postOrderAdapter, GetCustomerByDocumentAdapter getCustomerByDocumentAdapter) {
    	return new PostOrderUseCase(postOrderAdapter, getCustomerByDocumentAdapter);
    }
    
    @Bean
    public PostProductUseCasePort postProductUseCasePort(PostProductAdapter postProductAdapter) {
    	return new PostProductUseCase(postProductAdapter);
    }
    
    @Bean
    public UpdateProductUseCasePort updateProductUseCasePort(UpdateProductAdapter updateProductAdapter, GetCategoryByIDAdapter getCategoryByIDAdapter) {
    	return new UpdateProductUseCase(getCategoryByIDAdapter, updateProductAdapter);
    }
    
    @Bean
    public PostItemOrderUseCasePort postItemOrderUseCasePort(ItemOrderCustomerAdapter itemOrderCustomerAdapter) {
    	return new PostItemOrderUseCase(itemOrderCustomerAdapter);
    }

}
