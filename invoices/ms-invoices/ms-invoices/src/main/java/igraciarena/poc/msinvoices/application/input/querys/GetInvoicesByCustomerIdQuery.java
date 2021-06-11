package igraciarena.poc.msinvoices.application.input.querys;

import lombok.Getter;

@Getter
public class GetInvoicesByCustomerIdQuery {
    private final Long customerId;

    public GetInvoicesByCustomerIdQuery(Long customerId) {
        this.customerId = customerId;
    }
}
