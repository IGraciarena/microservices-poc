package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.dbentities.InvoiceItem;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.exceptions.NotFoundException;
import igraciarena.poc.msinvoices.application.input.GetInvoiceItemByIdUseCase;
import igraciarena.poc.msinvoices.application.input.querys.GetInvoiceItemByIdQuery;
import igraciarena.poc.msinvoices.domain.dtos.InvoiceItemResponse;
import igraciarena.poc.msinvoices.domain.mappers.InvoiceItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetInvoiceItemByIdService implements GetInvoiceItemByIdUseCase {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceItemMapper invoiceItemMapper = InvoiceItemMapper.INSTANCE;


    @Override
    public InvoiceItemResponse getInvoiceItemById(GetInvoiceItemByIdQuery getInvoiceItemByIdQuery) {
        Invoice invoice = invoiceRepository.findById(getInvoiceItemByIdQuery.getInvoiceId())
                .orElseThrow(() -> new NotFoundException("The invoice with the id: " + getInvoiceItemByIdQuery.getInvoiceId()
                        + "has not been found"));

        InvoiceItem invoiceItem = invoice.findInvoiceItemById(getInvoiceItemByIdQuery.getInvoiceItemId());

        return invoiceItemMapper.invoiceItemToInvoiceItemResponse(invoiceItem);
    }
}
