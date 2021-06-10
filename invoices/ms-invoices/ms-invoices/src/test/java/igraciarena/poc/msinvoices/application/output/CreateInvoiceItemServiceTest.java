package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.config.InvoiceProperties;
import igraciarena.poc.msinvoices.application.exceptions.FullItemListException;
import igraciarena.poc.msinvoices.application.input.commands.CreateInvoiceItemCommand;
import igraciarena.poc.msinvoices.utils.StubFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateInvoiceItemServiceTest implements StubFactory {

    @Mock
    InvoiceRepository invoiceRepository;

    @Mock
    InvoiceProperties invoiceProperties;

    CreateInvoiceItemService createInvoiceItemService;

    CreateInvoiceItemCommand createInvoiceItemCommand;

    @BeforeEach
    void setUp() {
        createInvoiceItemService = new CreateInvoiceItemService(invoiceRepository, invoiceProperties);
        createInvoiceItemCommand = new CreateInvoiceItemCommand(createInvoiceItemDto());
    }

    @Test
    void createInvoiceItem() throws FullItemListException {
        Invoice invoiceStub = createInvoiceStub();

        when(invoiceRepository.findById(any())).thenReturn(Optional.of(createInvoiceStub()));
        ArgumentCaptor<Invoice> argumentCaptor = ArgumentCaptor.forClass(Invoice.class);

        createInvoiceItemService.createInvoiceItem(createInvoiceItemCommand);

        verify(invoiceRepository, times(1)).save(argumentCaptor.capture());
        Invoice invoice = argumentCaptor.getValue();

        assertEquals(1, invoice.getInvoiceItems().size());

        assertEquals(invoiceStub.getId(), invoice.getInvoiceItems().get(0).getInvoice().getId());
        assertEquals(invoiceStub.getInvoiceItems().get(0).getPrice(), invoice.getInvoiceItems().get(0).getPrice().getPrice());
        assertEquals(invoiceStub.getInvoiceItems().get(0).getQuantity().getQuantity(), invoice.getInvoiceItems().get(0).getQuantity().getQuantity());
    }
}