package igraciarena.poc.msinvoices.application.input;


import igraciarena.poc.msinvoices.application.input.querys.GetInvoiceByIdQuery;
import igraciarena.poc.msinvoices.domain.dtos.InvoiceResponse;

public interface GetInvoiceByIdUseCase {

    InvoiceResponse getInvoiceById(GetInvoiceByIdQuery getInvoiceByIdQuery);
}
