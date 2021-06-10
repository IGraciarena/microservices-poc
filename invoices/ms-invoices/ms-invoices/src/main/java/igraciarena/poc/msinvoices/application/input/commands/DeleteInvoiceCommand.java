package igraciarena.poc.msinvoices.application.input.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteInvoiceCommand {

    private final Long invoiceId;

}
