package igraciarena.poc.msinvoices.application.input.querys;

import lombok.Getter;

@Getter
public class GetInvoiceItemByIdQuery {

    private final Long invoiceItemId;
    private final Long invoiceId;

    public GetInvoiceItemByIdQuery(Long invoiceItemId, Long invoiceId) {
        this.invoiceItemId = invoiceItemId;
        this.invoiceId = invoiceId;
    }
}
