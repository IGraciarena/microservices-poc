package igraciarena.poc.msinvoices.application.input;

import igraciarena.poc.msinvoices.application.input.commands.UpdateInvoiceCommand;

public interface UpdateInvoiceUseCase {

    void updateInvoice(UpdateInvoiceCommand updateInvoiceCommand);
}
