package igraciarena.poc.mscustomers.input;


import igraciarena.poc.mscustomers.input.querys.FindInvoicesByCustomerIdQuery;
import igraciarena.poc.mscustomers.domain.dtos.InvoiceDTO;

import java.util.List;

public interface FindInvoicesByCustomerIdUseCase {
    List<InvoiceDTO> findInvoicesByCustomerId(FindInvoicesByCustomerIdQuery findInvoicesByCustomerIdQuery);
}
