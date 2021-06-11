package igraciarena.poc.msproducts.domain.dtos;

import igraciarena.poc.msproducts.domain.enums.CategoryType;
import lombok.*;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {

    @NotNull
    private String name;
    @NotNull
    private CategoryType categoryType;
}
