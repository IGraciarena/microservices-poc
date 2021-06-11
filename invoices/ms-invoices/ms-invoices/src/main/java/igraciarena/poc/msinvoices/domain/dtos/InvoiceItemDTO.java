package igraciarena.poc.msinvoices.domain.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class InvoiceItemDTO {


    @Min(1)
    private int quantity;

    @Min(1)
    private Double price;

    @NotNull
    private Long productId;

    @NotNull
    private Long invoiceId;
}
