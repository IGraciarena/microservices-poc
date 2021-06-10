package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.exceptions.NotFoundException;
import igraciarena.poc.msinvoices.application.input.UpdateInvoiceUseCase;
import igraciarena.poc.msinvoices.application.input.commands.UpdateInvoiceCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UpdateInvoiceService implements UpdateInvoiceUseCase {

    private final InvoiceRepository invoiceRepository;

    @Override
    public void updateInvoice(UpdateInvoiceCommand updateInvoiceCommand) {

        Invoice invoice = invoiceRepository.findById(updateInvoiceCommand.getInvoiceId())
                .orElseThrow(() -> new NotFoundException("The invoice with the id: " + updateInvoiceCommand.getInvoiceId()
                        + "has not been found"));

        Invoice newInvoice = invoice.updateInvoice(updateInvoiceCommand.getNumber(), updateInvoiceCommand.getDescription());

        invoiceRepository.save(newInvoice);
    }

}
