package igraciarena.poc.msproducts.application.output;

import igraciarena.poc.msproducts.adapters.output.Category;
import igraciarena.poc.msproducts.adapters.output.persistance.CategoryRepository;
import igraciarena.poc.msproducts.application.exceptions.NotFoundException;
import igraciarena.poc.msproducts.application.input.UpdateCategoryUseCase;
import igraciarena.poc.msproducts.application.input.commands.UpdateCategoryCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateCategoryService implements UpdateCategoryUseCase {

    private final CategoryRepository categoryRepository;

    @Override
    public void updateCategory(UpdateCategoryCommand updateCategoryCommand) {

        Category category = categoryRepository.findById(updateCategoryCommand.getCategoryId())
                .orElseThrow(()-> new NotFoundException("The category with the Id " + updateCategoryCommand.getCategoryId() + " has not been found"));

        category.setName(updateCategoryCommand.getCategoryName());

        categoryRepository.save(category);
    }
}
