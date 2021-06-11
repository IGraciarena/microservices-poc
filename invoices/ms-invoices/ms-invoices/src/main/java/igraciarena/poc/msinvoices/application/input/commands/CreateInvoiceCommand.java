package igraciarena.poc.msinvoices.application.input.commands;

import igraciarena.poc.msinvoices.domain.dtos.InvoiceDTO;
import lombok.Getter;

@Getter
public class CreateInvoiceCommand {

    private final String numberInvoice;
    private final String description;
    private final Long customerId;

    public CreateInvoiceCommand(InvoiceDTO invoice) {
        this.numberInvoice = invoice.getNumberInvoice();
        this.customerId = invoice.getCustomerId();
        this.description = invoice.getDescription();
    }
}
