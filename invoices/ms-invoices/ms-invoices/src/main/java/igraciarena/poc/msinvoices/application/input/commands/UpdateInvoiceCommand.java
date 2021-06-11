package igraciarena.poc.msinvoices.application.input.commands;

import igraciarena.poc.msinvoices.domain.dtos.InvoiceDTO;
import lombok.Getter;

@Getter
public class UpdateInvoiceCommand {

    private final Long invoiceId;
    private final String number;
    private final String description;

    public UpdateInvoiceCommand(InvoiceDTO invoiceDTO, Long invoiceId){
        this.invoiceId = invoiceId;
        this.number = invoiceDTO.getNumberInvoice();
        this.description = invoiceDTO.getDescription();
    }

}
