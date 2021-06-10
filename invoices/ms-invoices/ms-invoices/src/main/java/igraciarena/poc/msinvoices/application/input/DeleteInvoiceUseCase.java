package igraciarena.poc.msinvoices.application.input;

import igraciarena.poc.msinvoices.application.input.commands.DeleteInvoiceCommand;

public interface DeleteInvoiceUseCase {

    void deleteInvoice(DeleteInvoiceCommand deleteInvoiceCommand);
}
