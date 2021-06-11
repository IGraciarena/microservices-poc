package igraciarena.poc.msproducts.application.input.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateCategoryCommand {

    private final String categoryId;
    private final String categoryName;
}
