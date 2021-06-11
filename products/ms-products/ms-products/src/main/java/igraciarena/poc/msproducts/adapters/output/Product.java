package igraciarena.poc.msproducts.adapters.output;

import igraciarena.poc.msproducts.domain.dtos.CategoryResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document
@Getter
@Setter
public class Product {
    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    private String description;

    private int Stock;

    private Double price;

    private Date createAt;

    private CategoryResponse category;

}
