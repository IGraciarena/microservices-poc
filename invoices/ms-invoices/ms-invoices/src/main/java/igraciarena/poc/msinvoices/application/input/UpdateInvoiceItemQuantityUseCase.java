package igraciarena.poc.msinvoices.application.input;


import igraciarena.poc.msinvoices.application.input.commands.UpdateInvoiceItemQuantityCommand;

public interface UpdateInvoiceItemQuantityUseCase {
    void updateInvoiceItemQuantity(UpdateInvoiceItemQuantityCommand updateInvoiceItemCommand);
}
