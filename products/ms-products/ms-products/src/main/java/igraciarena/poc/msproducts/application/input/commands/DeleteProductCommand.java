package igraciarena.poc.msproducts.application.input.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteProductCommand {

    private final String productId;
}
