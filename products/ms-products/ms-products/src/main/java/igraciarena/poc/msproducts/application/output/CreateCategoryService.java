package igraciarena.poc.msproducts.application.output;

import igraciarena.poc.msproducts.adapters.output.Category;
import igraciarena.poc.msproducts.adapters.output.persistance.CategoryRepository;
import igraciarena.poc.msproducts.application.input.CreateCategoryUseCase;
import igraciarena.poc.msproducts.application.input.commands.CreateCategoryCommand;
import igraciarena.poc.msproducts.domain.mappers.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCategoryService implements CreateCategoryUseCase {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Override
    public void createCategory(CreateCategoryCommand createCategoryCommand) {
        Category category = categoryMapper.createCategoryCommandToCategory(createCategoryCommand);

        categoryRepository.save(category);
    }
}
