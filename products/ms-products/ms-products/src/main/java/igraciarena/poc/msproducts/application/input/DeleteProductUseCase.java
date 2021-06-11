package igraciarena.poc.msproducts.application.input;


import igraciarena.poc.msproducts.application.input.commands.DeleteProductCommand;

public interface DeleteProductUseCase {

    void deleteProduct(DeleteProductCommand deleteProductCommand);
}
