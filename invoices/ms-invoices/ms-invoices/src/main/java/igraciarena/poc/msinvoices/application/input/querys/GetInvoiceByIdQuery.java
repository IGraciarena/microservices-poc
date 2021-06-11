package igraciarena.poc.msinvoices.application.input.querys;

import lombok.Getter;

@Getter
public class GetInvoiceByIdQuery {

    private final Long invoiceId;

    public GetInvoiceByIdQuery(Long invoiceId) {
        this.invoiceId = invoiceId;
    }
}
