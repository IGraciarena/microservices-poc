package igraciarena.poc.msproducts.application.input.commands;

import igraciarena.poc.msproducts.domain.dtos.ProductDTO;
import lombok.Getter;

@Getter
public class UpdateProductCommand {

    private final String productId;
    private String name;
    private String description;
    private int stock;
    private Double price;

    public UpdateProductCommand(String productId, ProductDTO productDTO) {
        this.productId = productId;
        this.name = productDTO.getName();
        this.description = productDTO.getDescription();
        this.stock = productDTO.getStock();
        this.price = productDTO.getPrice();
    }
}
