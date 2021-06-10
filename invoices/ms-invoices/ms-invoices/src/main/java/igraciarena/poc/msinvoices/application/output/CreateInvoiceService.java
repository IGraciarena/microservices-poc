package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.input.CreateInvoiceUseCase;
import igraciarena.poc.msinvoices.application.input.commands.CreateInvoiceCommand;
import igraciarena.poc.msinvoices.domain.mappers.InvoiceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateInvoiceService implements CreateInvoiceUseCase {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper = InvoiceMapper.INSTANCE;

    @Override
    public void createInvoice(CreateInvoiceCommand createInvoiceCommand) {

        Invoice invoice = invoiceMapper.createInvoiceCommandToInvoice(createInvoiceCommand);

        invoiceRepository.save(invoice);
    }
}
