package igraciarena.poc.msinvoices.application.input.commands;

import igraciarena.poc.msinvoices.domain.dtos.InvoiceItemDTO;
import lombok.Getter;

@Getter
public class CreateInvoiceItemCommand {

    private final Double price;
    private final int quantity;
    private final Long productId;
    private final Long invoiceId;

    public CreateInvoiceItemCommand(InvoiceItemDTO invoiceItem) {
        this.price = invoiceItem.getPrice();
        this.quantity = invoiceItem.getQuantity();
        this.productId = invoiceItem.getProductId();
        this.invoiceId = invoiceItem.getInvoiceId();
    }
}
