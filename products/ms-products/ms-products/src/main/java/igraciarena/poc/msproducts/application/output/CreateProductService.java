package igraciarena.poc.msproducts.application.output;

import igraciarena.poc.msproducts.adapters.output.Category;
import igraciarena.poc.msproducts.adapters.output.Product;
import igraciarena.poc.msproducts.adapters.output.persistance.CategoryRepository;
import igraciarena.poc.msproducts.adapters.output.persistance.ProductRepository;
import igraciarena.poc.msproducts.application.exceptions.NotFoundException;
import igraciarena.poc.msproducts.application.input.CreateProductUseCase;
import igraciarena.poc.msproducts.application.input.commands.CreateProductCommand;
import igraciarena.poc.msproducts.domain.dtos.CategoryResponse;
import igraciarena.poc.msproducts.domain.dtos.ProductResponse;
import igraciarena.poc.msproducts.domain.mappers.CategoryMapper;
import igraciarena.poc.msproducts.domain.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class CreateProductService implements CreateProductUseCase {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    @Override
    public void createProduct(CreateProductCommand createProductCommand) {

        Product product = productMapper.createProductCommandToProduct(createProductCommand);

        Category category = categoryRepository.findById(createProductCommand.getCategoryId()).
                orElseThrow(() -> new NotFoundException("The category with the id " + createProductCommand.getCategoryId() + "has not been found"));

        if (category.getProducts() == null) {
            category.setProducts(new ArrayList<>());
        }

        ProductResponse productResponse = productMapper.productToProductResponse(product);
        category.getProducts().add(productResponse);
        CategoryResponse categoryResponse = categoryMapper.categoryToCategoryResponse(category);
        product.setCategory(categoryResponse);

        productRepository.save(product);
        categoryRepository.save(category);
    }
}
