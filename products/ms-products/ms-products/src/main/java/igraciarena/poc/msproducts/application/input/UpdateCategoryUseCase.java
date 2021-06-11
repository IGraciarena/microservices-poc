package igraciarena.poc.msproducts.application.input;


import igraciarena.poc.msproducts.application.input.commands.UpdateCategoryCommand;

public interface UpdateCategoryUseCase {

    void updateCategory(UpdateCategoryCommand updateCategoryCommand);
}
