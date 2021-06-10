package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.input.commands.DeleteInvoiceItemCommand;
import igraciarena.poc.msinvoices.utils.StubFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteInvoiceItemServiceTest implements StubFactory {

    @Mock
    InvoiceRepository invoiceRepository;

    DeleteInvoiceItemService deleteInvoiceItemService;

    DeleteInvoiceItemCommand deleteInvoiceItemCommand;

    @BeforeEach
    void setUp() {
        deleteInvoiceItemService = new DeleteInvoiceItemService(invoiceRepository);
        deleteInvoiceItemCommand = new DeleteInvoiceItemCommand(1L,1L);
    }

    @Test
    void deleteInvoiceItem() {
        when(invoiceRepository.findById(anyLong())).thenReturn(Optional.of(createInvoiceStub()));

        ArgumentCaptor<Invoice> argumentCaptor = ArgumentCaptor.forClass(Invoice.class);

        deleteInvoiceItemService.deleteInvoiceItem(deleteInvoiceItemCommand);

        verify(invoiceRepository, times(1)).findById(anyLong());
        verify(invoiceRepository, times(1)).save(argumentCaptor.capture());
        Invoice invoice = argumentCaptor.getValue();

        assertEquals(0, invoice.getInvoiceItems().size());
    }
}