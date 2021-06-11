package igraciarena.poc.msproducts.application.output;

import igraciarena.poc.msproducts.adapters.output.Product;
import igraciarena.poc.msproducts.adapters.output.persistance.ProductRepository;
import igraciarena.poc.msproducts.application.exceptions.NotFoundException;
import igraciarena.poc.msproducts.application.input.UpdateProductUseCase;
import igraciarena.poc.msproducts.application.input.commands.UpdateProductCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateProductService implements UpdateProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public void updateProduct(UpdateProductCommand updateProductCommand) {

        Product product = productRepository.findById(updateProductCommand.getProductId())
                .orElseThrow(() -> new NotFoundException("The product with the id " + updateProductCommand.getProductId() + "has not been found"));

        product.setName(updateProductCommand.getName());
        product.setPrice(updateProductCommand.getPrice());
        product.setStock(updateProductCommand.getStock());
        product.setDescription(updateProductCommand.getDescription());

        productRepository.save(product);
    }
}
