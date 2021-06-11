package igraciarena.poc.msproducts.application.output;

import igraciarena.poc.msproducts.adapters.output.persistance.CategoryRepository;
import igraciarena.poc.msproducts.application.exceptions.NotFoundException;
import igraciarena.poc.msproducts.application.input.FindCategoryByIdUseCase;
import igraciarena.poc.msproducts.application.input.querys.FindCategoryByIdQuery;
import igraciarena.poc.msproducts.domain.dtos.CategoryResponse;
import igraciarena.poc.msproducts.domain.mappers.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindCategoryByIdService implements FindCategoryByIdUseCase {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Override
    public CategoryResponse findCategoryById(FindCategoryByIdQuery findCategoryByIdQuery) {

        return categoryMapper.categoryToCategoryResponse(categoryRepository.findById(findCategoryByIdQuery.getCategoryId())
                .orElseThrow(() -> new NotFoundException("The category with the Id " +
                        findCategoryByIdQuery.getCategoryId() + " has not been found")));
    }
}
