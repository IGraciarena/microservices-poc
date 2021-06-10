package igraciarena.poc.msproducts.application.output;

import igraciarena.poc.msproducts.adapters.output.Category;
import igraciarena.poc.msproducts.adapters.output.persistance.CategoryRepository;
import igraciarena.poc.msproducts.application.exceptions.NotFoundException;
import igraciarena.poc.msproducts.application.input.DeleteCategoryUseCase;
import igraciarena.poc.msproducts.application.input.commands.DeleteCategoryCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteCategoryService implements DeleteCategoryUseCase {

    private final CategoryRepository categoryRepository;

    @Override
    public void deleteCategory(DeleteCategoryCommand deleteCategoryCommand) {
        Category category = categoryRepository.findById(deleteCategoryCommand.getCategoryId())
                .orElseThrow(() -> new NotFoundException("The category with the Id " + deleteCategoryCommand.getCategoryId() + " has not been found"));

        categoryRepository.delete(category);
    }
}
