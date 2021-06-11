package igraciarena.poc.msproducts.application.input;


import igraciarena.poc.msproducts.application.input.commands.CreateProductCommand;

public interface CreateProductUseCase {

    void createProduct(CreateProductCommand createProductCommand);
}
