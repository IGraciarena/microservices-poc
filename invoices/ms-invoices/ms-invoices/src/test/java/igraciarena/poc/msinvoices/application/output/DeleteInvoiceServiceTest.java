package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.input.commands.DeleteInvoiceCommand;
import igraciarena.poc.msinvoices.utils.StubFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteInvoiceServiceTest implements StubFactory {

    @Mock
    InvoiceRepository invoiceRepository;

    DeleteInvoiceService deleteInvoiceService;

    DeleteInvoiceCommand deleteInvoiceCommand;

    @BeforeEach
    void setUp() {
        deleteInvoiceService = new DeleteInvoiceService(invoiceRepository);
        deleteInvoiceCommand = new DeleteInvoiceCommand(1L);
    }

    @Test
    void deleteInvoice() {
        when(invoiceRepository.findById(anyLong())).thenReturn(Optional.of(createInvoiceStub()));

        deleteInvoiceService.deleteInvoice(deleteInvoiceCommand);

        verify(invoiceRepository, times(1)).findById(anyLong());
        verify(invoiceRepository, times(1)).delete(any(Invoice.class));
    }
}