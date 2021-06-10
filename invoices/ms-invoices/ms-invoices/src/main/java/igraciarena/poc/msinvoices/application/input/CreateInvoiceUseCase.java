package igraciarena.poc.msinvoices.application.input;

import igraciarena.poc.msinvoices.application.input.commands.CreateInvoiceCommand;

public interface CreateInvoiceUseCase {

    void createInvoice(CreateInvoiceCommand createInvoiceCommand);
}
