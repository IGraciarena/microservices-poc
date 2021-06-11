package igraciarena.poc.msproducts.application.output;

import igraciarena.poc.msproducts.adapters.output.Product;
import igraciarena.poc.msproducts.adapters.output.persistance.ProductRepository;
import igraciarena.poc.msproducts.application.exceptions.NotFoundException;
import igraciarena.poc.msproducts.application.input.FindProductByIdUseCase;
import igraciarena.poc.msproducts.application.input.querys.FindProductByIdQuery;
import igraciarena.poc.msproducts.domain.dtos.ProductResponse;
import igraciarena.poc.msproducts.domain.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindProductByIdService implements FindProductByIdUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    @Override
    public ProductResponse findProductById(FindProductByIdQuery findProductByIdQuery) {
        Product product = productRepository.findById(findProductByIdQuery.getProductId())
                .orElseThrow(() -> new NotFoundException("The product with the id " + findProductByIdQuery.getProductId() + "has not been found"));

        return productMapper.productToProductResponse(product);
    }
}
