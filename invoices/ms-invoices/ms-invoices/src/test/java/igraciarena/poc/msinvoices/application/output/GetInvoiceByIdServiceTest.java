package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.input.querys.GetInvoiceByIdQuery;
import igraciarena.poc.msinvoices.domain.dtos.InvoiceResponse;
import igraciarena.poc.msinvoices.utils.StubFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetInvoiceByIdServiceTest implements StubFactory {

    @Mock
    InvoiceRepository invoiceRepository;

    GetInvoiceByIdService getInvoiceByIdService;

    GetInvoiceByIdQuery getInvoiceByIdQuery;

    @BeforeEach
    void setUp() {
        getInvoiceByIdService = new GetInvoiceByIdService(invoiceRepository);
        getInvoiceByIdQuery = new GetInvoiceByIdQuery(1L);
    }

    @Test
    void getInvoiceById() {
        Invoice invoiceStub = createInvoiceStub();
        when(invoiceRepository.findById(anyLong())).thenReturn(Optional.of(createInvoiceStub()));

        InvoiceResponse invoiceResponse = getInvoiceByIdService.getInvoiceById(getInvoiceByIdQuery);

        verify(invoiceRepository, times(1)).findById(anyLong());
        assertEquals(invoiceStub.getNumberInvoice(), invoiceResponse.getNumberInvoice());
        assertEquals(invoiceStub.getDescription(), invoiceResponse.getDescription());
        assertEquals(invoiceStub.getId(), invoiceResponse.getId());
    }
}