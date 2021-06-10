package igraciarena.poc.msproducts.application.input.commands;

import igraciarena.poc.msproducts.domain.dtos.ProductDTO;
import lombok.Getter;

@Getter
public class CreateProductCommand {
    private String name;
    private String description;
    private String categoryId;
    private int stock;
    private Double price;

    public CreateProductCommand(ProductDTO productDTO){
        this.name = productDTO.getName();
        this.description = productDTO.getDescription();
        this.categoryId = productDTO.getCategoryId();
        this.stock = productDTO.getStock();
        this.price = productDTO.getPrice();
    }

}

