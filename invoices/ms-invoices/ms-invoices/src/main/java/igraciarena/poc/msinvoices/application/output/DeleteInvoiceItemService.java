package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.exceptions.NotFoundException;
import igraciarena.poc.msinvoices.application.input.DeleteInvoiceItemUseCase;
import igraciarena.poc.msinvoices.application.input.commands.DeleteInvoiceItemCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteInvoiceItemService implements DeleteInvoiceItemUseCase {

    private final InvoiceRepository invoiceRepository;


    @Override
    public void deleteInvoiceItem(DeleteInvoiceItemCommand deleteInvoiceItemCommand) {
        Invoice invoice = invoiceRepository.findById(deleteInvoiceItemCommand.getInvoiceId())
                .orElseThrow(() -> new NotFoundException("The invoice with the id: " + deleteInvoiceItemCommand.getInvoiceId()
                        + "has not been found"));

        invoice.removeInvoiceItem(deleteInvoiceItemCommand.getInvoiceItemId());

        invoiceRepository.save(invoice);
    }
}
