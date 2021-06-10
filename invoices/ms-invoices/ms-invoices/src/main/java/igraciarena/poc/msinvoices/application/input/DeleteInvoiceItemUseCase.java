package igraciarena.poc.msinvoices.application.input;


import igraciarena.poc.msinvoices.application.input.commands.DeleteInvoiceItemCommand;

public interface DeleteInvoiceItemUseCase {

    void deleteInvoiceItem(DeleteInvoiceItemCommand deleteInvoiceItemCommand);
}
