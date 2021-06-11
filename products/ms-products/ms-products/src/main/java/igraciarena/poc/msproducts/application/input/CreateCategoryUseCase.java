package igraciarena.poc.msproducts.application.input;


import igraciarena.poc.msproducts.application.input.commands.CreateCategoryCommand;

public interface CreateCategoryUseCase {

    void createCategory(CreateCategoryCommand createCategoryCommand);
}
