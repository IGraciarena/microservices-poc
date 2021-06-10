package igraciarena.poc.msproducts.domain.mappers;

import igraciarena.poc.msproducts.adapters.output.Product;
import igraciarena.poc.msproducts.application.input.commands.CreateProductCommand;
import igraciarena.poc.msproducts.domain.dtos.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper{

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product createProductCommandToProduct(CreateProductCommand createProductCommand);

    @Mapping(target = "categoryId", source = "category.id")
    ProductResponse productToProductResponse(Product Product);
}
