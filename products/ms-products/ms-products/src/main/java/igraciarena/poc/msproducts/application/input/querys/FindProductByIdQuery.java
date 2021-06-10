package igraciarena.poc.msproducts.application.input.querys;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindProductByIdQuery {

    private final String productId;
}
