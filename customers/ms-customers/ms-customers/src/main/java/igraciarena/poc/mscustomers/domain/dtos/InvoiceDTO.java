package igraciarena.poc.mscustomers.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class InvoiceDTO {
    private final Long invoiceId;
    private final Double price;
    private final String createAt;
}
