package igraciarena.poc.msinvoices.application.input.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteInvoiceItemCommand {

    private final Long invoiceId;
    private final Long invoiceItemId;

}
