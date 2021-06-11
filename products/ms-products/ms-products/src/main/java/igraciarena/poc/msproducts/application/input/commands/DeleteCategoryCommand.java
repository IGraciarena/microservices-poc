package igraciarena.poc.msproducts.application.input.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteCategoryCommand {

    private final String categoryId;
}
