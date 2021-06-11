package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.input.querys.GetInvoiceItemByIdQuery;
import igraciarena.poc.msinvoices.domain.dtos.InvoiceItemResponse;
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
class GetInvoiceItemByIdServiceTest implements StubFactory {

    @Mock
    InvoiceRepository invoiceRepository;

    GetInvoiceItemByIdService getInvoiceItemByIdService;

    GetInvoiceItemByIdQuery getInvoiceItemByIdQuery;

    @BeforeEach
    void setUp() {
        getInvoiceItemByIdService = new GetInvoiceItemByIdService(invoiceRepository);

        getInvoiceItemByIdQuery = new GetInvoiceItemByIdQuery(1L, 1L);
    }

    @Test
    void getInvoiceItemById() {
        Invoice invoiceStub = createInvoiceStub();

        when(invoiceRepository.findById(anyLong())).thenReturn(Optional.of(createInvoiceStub()));
        InvoiceItemResponse invoiceItemResponse = getInvoiceItemByIdService.getInvoiceItemById(getInvoiceItemByIdQuery);

        verify(invoiceRepository, times(1)).findById(anyLong());
        assertEquals(invoiceStub.getId(), invoiceItemResponse.getInvoiceId());
        assertEquals(invoiceStub.getInvoiceItems().get(0).getPrice(), invoiceItemResponse.getPrice());
        assertEquals(invoiceStub.getInvoiceItems().get(0).getQuantity(), invoiceItemResponse.getQuantity());

    }
}