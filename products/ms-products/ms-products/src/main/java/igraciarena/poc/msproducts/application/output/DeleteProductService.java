package igraciarena.poc.msproducts.application.output;

import igraciarena.poc.msproducts.adapters.output.Product;
import igraciarena.poc.msproducts.adapters.output.persistance.ProductRepository;
import igraciarena.poc.msproducts.application.exceptions.NotFoundException;
import igraciarena.poc.msproducts.application.input.DeleteProductUseCase;
import igraciarena.poc.msproducts.application.input.commands.DeleteProductCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProductService implements DeleteProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public void deleteProduct(DeleteProductCommand deleteProductCommand) {

        Product product = productRepository.findById(deleteProductCommand.getProductId())
                .orElseThrow(() -> new NotFoundException("The product with the id " + deleteProductCommand.getProductId() + "has not been found"));

        productRepository.delete(product);
    }
}
