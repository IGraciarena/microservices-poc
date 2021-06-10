package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.exceptions.NotFoundException;
import igraciarena.poc.msinvoices.application.input.UpdateInvoiceItemQuantityUseCase;
import igraciarena.poc.msinvoices.application.input.commands.UpdateInvoiceItemQuantityCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UpdateInvoiceItemQuantityService implements UpdateInvoiceItemQuantityUseCase {

    private final InvoiceRepository invoiceRepository;

    @Override
    public void updateInvoiceItemQuantity(UpdateInvoiceItemQuantityCommand updateInvoiceItemCommand) {
        Invoice invoice = invoiceRepository.findById(updateInvoiceItemCommand.getInvoiceId())
                .orElseThrow(() -> new NotFoundException("The invoice with the id: " + updateInvoiceItemCommand.getInvoiceId()
                        + "has not been found"));

        invoice.updateInvoiceItemQuantity(updateInvoiceItemCommand.getInvoiceItemId(), updateInvoiceItemCommand.getQuantity());

        invoiceRepository.save(invoice);
    }
}
