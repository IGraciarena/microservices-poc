package igraciarena.poc.msproducts.application.input;


import igraciarena.poc.msproducts.application.input.querys.FindProductByIdQuery;
import igraciarena.poc.msproducts.domain.dtos.ProductResponse;

public interface FindProductByIdUseCase {

    ProductResponse findProductById(FindProductByIdQuery findProductByIdQuery);
}
