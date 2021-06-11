package igraciarena.poc.msproducts.domain.dtos;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    @NotNull
    private String name;
    @NotNull
    private String description;
    private String categoryId;

    private int Stock;
    private Double price;
}
