package igraciarena.poc.msinvoices.application.input;


import igraciarena.poc.msinvoices.application.input.querys.GetInvoiceItemByIdQuery;
import igraciarena.poc.msinvoices.domain.dtos.InvoiceItemResponse;

public interface GetInvoiceItemByIdUseCase {
    InvoiceItemResponse getInvoiceItemById(GetInvoiceItemByIdQuery getInvoiceItemByIdQuery);
}
