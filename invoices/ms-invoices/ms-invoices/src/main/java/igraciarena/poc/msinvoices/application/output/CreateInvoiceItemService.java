package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.config.InvoiceProperties;
import igraciarena.poc.msinvoices.application.exceptions.FullItemListException;
import igraciarena.poc.msinvoices.application.exceptions.NotFoundException;
import igraciarena.poc.msinvoices.application.input.CreateInvoiceItemUseCase;
import igraciarena.poc.msinvoices.application.input.commands.CreateInvoiceItemCommand;
import igraciarena.poc.msinvoices.domain.mappers.InvoiceItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateInvoiceItemService implements CreateInvoiceItemUseCase {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceItemMapper invoiceItemMapper = InvoiceItemMapper.INSTANCE;
    private final InvoiceProperties invoiceProperties;


    @Override
    public void createInvoiceItem(CreateInvoiceItemCommand createInvoiceItemCommand) throws FullItemListException {

        Invoice invoice = invoiceRepository.findById(createInvoiceItemCommand.getInvoiceId())
                .orElseThrow(() -> new NotFoundException(
                        "The invoice with the id: "
                                + createInvoiceItemCommand.getInvoiceId()
                                + "has not been found"));

        int maxSize = invoice.getInvoiceItems().size();

        if (maxSize >= invoiceProperties.getItemListMax()) {
            throw new FullItemListException("You cannot add more than " + invoiceProperties.getItemListMax() + " by invoice, create an other invoice");
        }

        invoice.addInvoiceItem(createInvoiceItemCommand.getQuantity(),
                createInvoiceItemCommand.getPrice(),
                createInvoiceItemCommand.getProductId());

        invoiceRepository.save(invoice);
    }
}
