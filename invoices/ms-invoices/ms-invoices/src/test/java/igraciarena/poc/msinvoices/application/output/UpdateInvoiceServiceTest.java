package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.input.commands.UpdateInvoiceCommand;
import igraciarena.poc.msinvoices.utils.StubFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateInvoiceServiceTest implements StubFactory {

    @Mock
    InvoiceRepository invoiceRepository;

    UpdateInvoiceService updateInvoiceService;

    UpdateInvoiceCommand updateInvoiceCommand;

    @BeforeEach
    void setUp() {
        updateInvoiceService = new UpdateInvoiceService(invoiceRepository);
        updateInvoiceCommand = new UpdateInvoiceCommand(createInvoiceDTOStub(), 1L);
    }

    @Test
    void updateInvoice() {
        Invoice invoiceStub = createInvoiceStub();
        when(invoiceRepository.findById(anyLong())).thenReturn(Optional.of(createInvoiceStub()));
        ArgumentCaptor<Invoice> argumentCaptor = ArgumentCaptor.forClass(Invoice.class);

        updateInvoiceService.updateInvoice(updateInvoiceCommand);

        verify(invoiceRepository, times(1)).findById(anyLong());
        verify(invoiceRepository, times(1)).save(argumentCaptor.capture());

        Invoice invoice = argumentCaptor.getValue();
        assertEquals(invoiceStub.getId(), invoice.getId());
        assertEquals(invoiceStub.getDescription(), invoice.getDescription());
        assertEquals(invoiceStub.getInvoiceItems().get(0).getId(), invoice.getInvoiceItems().get(0).getId());

    }
}