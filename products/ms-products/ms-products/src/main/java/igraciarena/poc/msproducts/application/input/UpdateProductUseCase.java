package igraciarena.poc.msproducts.application.input;


import igraciarena.poc.msproducts.application.input.commands.UpdateProductCommand;

public interface UpdateProductUseCase {

    void updateProduct(UpdateProductCommand updateProductCommand);
}
