package igraciarena.poc.mscustomers.input.querys;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindInvoicesByCustomerIdQuery {
    private final Long customerId;
}
