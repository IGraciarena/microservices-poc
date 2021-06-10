package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.input.commands.UpdateInvoiceItemQuantityCommand;
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
class UpdateInvoiceItemQuantityServiceTest implements StubFactory {

    @Mock
    InvoiceRepository invoiceRepository;

    UpdateInvoiceItemQuantityService updateInvoiceItemQuantityService;

    UpdateInvoiceItemQuantityCommand updateInvoiceItemQuantityCommand;

    @BeforeEach
    void setUp() {
        updateInvoiceItemQuantityService = new UpdateInvoiceItemQuantityService(invoiceRepository);
        updateInvoiceItemQuantityCommand = new UpdateInvoiceItemQuantityCommand(createInvoiceItemDto(), 1L);
    }

    @Test
    void updateInvoiceItemQuantity() {
        when(invoiceRepository.findById(anyLong())).thenReturn(Optional.of(createInvoiceStub()));

        ArgumentCaptor<Invoice> argumentCaptor = ArgumentCaptor.forClass(Invoice.class);

        updateInvoiceItemQuantityService.updateInvoiceItemQuantity(updateInvoiceItemQuantityCommand);

        verify(invoiceRepository, times(1)).findById(anyLong());
        verify(invoiceRepository, times(1)).save(argumentCaptor.capture());

        Invoice invoice = argumentCaptor.getValue();
        assertEquals(1, invoice.getInvoiceItems().size());
        assertEquals(25, invoice.getInvoiceItems().get(0).getQuantity().getQuantity());
    }
}