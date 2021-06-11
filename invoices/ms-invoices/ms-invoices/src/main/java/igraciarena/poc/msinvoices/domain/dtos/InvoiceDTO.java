package igraciarena.poc.msinvoices.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class InvoiceDTO {

    @NotNull
    private String numberInvoice;

    @NotNull
    private String description;

    @NotNull
    private Long customerId;
}
