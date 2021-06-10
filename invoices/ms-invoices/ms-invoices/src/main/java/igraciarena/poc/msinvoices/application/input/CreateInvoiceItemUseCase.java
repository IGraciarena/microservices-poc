package igraciarena.poc.msinvoices.application.input;


import igraciarena.poc.msinvoices.application.exceptions.FullItemListException;
import igraciarena.poc.msinvoices.application.input.commands.CreateInvoiceItemCommand;

public interface CreateInvoiceItemUseCase {

    void createInvoiceItem(CreateInvoiceItemCommand createInvoiceItemCommand) throws FullItemListException;
}
