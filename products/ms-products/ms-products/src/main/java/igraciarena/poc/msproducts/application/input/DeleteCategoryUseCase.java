package igraciarena.poc.msproducts.application.input;


import igraciarena.poc.msproducts.application.input.commands.DeleteCategoryCommand;

public interface DeleteCategoryUseCase {

    void deleteCategory(DeleteCategoryCommand deleteCategoryCommand);
}
