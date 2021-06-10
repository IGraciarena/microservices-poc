package igraciarena.poc.msinvoices.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class InvoiceItemResponse extends InvoiceItemDTO {

    private Long id;
}
