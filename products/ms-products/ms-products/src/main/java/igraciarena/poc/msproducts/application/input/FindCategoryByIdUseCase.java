package igraciarena.poc.msproducts.application.input;


import igraciarena.poc.msproducts.application.input.querys.FindCategoryByIdQuery;
import igraciarena.poc.msproducts.domain.dtos.CategoryResponse;

public interface FindCategoryByIdUseCase {

    CategoryResponse findCategoryById(FindCategoryByIdQuery findCategoryByIdQuery);
}
