package igraciarena.poc.msproducts.application.input.commands;

import igraciarena.poc.msproducts.domain.dtos.CategoryDTO;
import igraciarena.poc.msproducts.domain.enums.CategoryType;
import lombok.Getter;

@Getter
public class CreateCategoryCommand {

    private final String name;
    private final CategoryType categoryType;

    public CreateCategoryCommand(CategoryDTO categoryDTO) {
        this.name = categoryDTO.getName();
        this.categoryType = categoryDTO.getCategoryType();
    }
}
