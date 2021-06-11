package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.exceptions.NotFoundException;
import igraciarena.poc.msinvoices.application.input.GetInvoiceByIdUseCase;
import igraciarena.poc.msinvoices.application.input.querys.GetInvoiceByIdQuery;
import igraciarena.poc.msinvoices.domain.dtos.InvoiceResponse;
import igraciarena.poc.msinvoices.domain.mappers.InvoiceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetInvoiceByIdService implements GetInvoiceByIdUseCase {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper = InvoiceMapper.INSTANCE;


    @Override
    public InvoiceResponse getInvoiceById(GetInvoiceByIdQuery getInvoiceByIdQuery) {
        Invoice invoice = invoiceRepository.findById(getInvoiceByIdQuery.getInvoiceId())
                .orElseThrow(() -> new NotFoundException("The invoice with the id: " + getInvoiceByIdQuery.getInvoiceId()
                        + "has not been found"));

        return invoiceMapper.invoiceToInvoiceResponse(invoice);
    }


}
