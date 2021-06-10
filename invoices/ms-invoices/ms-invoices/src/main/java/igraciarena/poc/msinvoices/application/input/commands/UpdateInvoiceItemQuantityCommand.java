package igraciarena.poc.msinvoices.application.input.commands;

import igraciarena.poc.msinvoices.domain.dtos.InvoiceItemDTO;
import lombok.Getter;

@Getter
public class UpdateInvoiceItemQuantityCommand {
    private final int quantity;
    private final Long  invoiceId;
    private final Long invoiceItemId;

    public UpdateInvoiceItemQuantityCommand(InvoiceItemDTO invoiceItem, Long invoiceItemId){
        this.quantity = invoiceItem.getQuantity();
        this.invoiceId = invoiceItem.getInvoiceId();
        this.invoiceItemId = invoiceItemId;
    }
}
