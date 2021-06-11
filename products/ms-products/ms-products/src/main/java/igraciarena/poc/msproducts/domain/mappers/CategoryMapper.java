package igraciarena.poc.msproducts.domain.mappers;

import igraciarena.poc.msproducts.adapters.output.Category;
import igraciarena.poc.msproducts.application.input.commands.CreateCategoryCommand;
import igraciarena.poc.msproducts.domain.dtos.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category createCategoryCommandToCategory(CreateCategoryCommand createCategoryCommand);

    CategoryResponse categoryToCategoryResponse(Category category);
}
