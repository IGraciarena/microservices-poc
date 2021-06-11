package igraciarena.poc.msproducts.adapters.output;


import igraciarena.poc.msproducts.domain.dtos.ProductResponse;
import igraciarena.poc.msproducts.domain.enums.CategoryType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.List;
import java.util.UUID;

@Document
@Getter
@Setter
public class Category {
    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    private CategoryType categoryType;

    @Field(name = "products")
    private List<ProductResponse> products;

}
