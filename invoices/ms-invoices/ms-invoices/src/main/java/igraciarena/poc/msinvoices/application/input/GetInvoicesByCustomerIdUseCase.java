package igraciarena.poc.msinvoices.application.input;

import igraciarena.poc.msinvoices.application.input.querys.GetInvoicesByCustomerIdQuery;
import igraciarena.poc.proto.Invoice;

import java.util.List;

public interface GetInvoicesByCustomerIdUseCase {
    List<Invoice> getInvoicesByCustomerId(GetInvoicesByCustomerIdQuery getInvoicesByCustomerIdQuery);
}
