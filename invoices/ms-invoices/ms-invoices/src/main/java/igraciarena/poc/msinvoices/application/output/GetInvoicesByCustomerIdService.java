package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.input.GetInvoicesByCustomerIdUseCase;
import igraciarena.poc.msinvoices.application.input.querys.GetInvoicesByCustomerIdQuery;
import igraciarena.poc.proto.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GetInvoicesByCustomerIdService implements GetInvoicesByCustomerIdUseCase {

    private final InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getInvoicesByCustomerId(GetInvoicesByCustomerIdQuery getInvoicesByCustomerIdQuery) {
        return invoiceRepository.findAllByCustomerId(getInvoicesByCustomerIdQuery.getCustomerId())
                .stream().map(invoice -> Invoice.newBuilder()
                        .setInvoiceId(invoice.getId())
                        .setTotal(invoice.getTotal())
                        .setCreateAt(invoice.getCreateAt().toString())
                        .build()).collect(Collectors.toList());
    }
}
