package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.exceptions.NotFoundException;
import igraciarena.poc.msinvoices.application.input.DeleteInvoiceUseCase;
import igraciarena.poc.msinvoices.application.input.commands.DeleteInvoiceCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteInvoiceService implements DeleteInvoiceUseCase {

    private final InvoiceRepository invoiceRepository;

    @Override
    public void deleteInvoice(DeleteInvoiceCommand deleteInvoiceCommand) {
        Invoice invoice = invoiceRepository.findById(deleteInvoiceCommand.getInvoiceId())
                .orElseThrow(() -> new NotFoundException("The invoice with the id: " + deleteInvoiceCommand.getInvoiceId()
                        + "has not been found"));

        invoiceRepository.delete(invoice);
    }
}
