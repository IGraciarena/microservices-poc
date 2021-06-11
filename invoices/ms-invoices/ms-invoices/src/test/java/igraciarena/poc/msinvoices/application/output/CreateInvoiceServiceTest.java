package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.persistance.InvoiceRepository;
import igraciarena.poc.msinvoices.application.input.commands.CreateInvoiceCommand;
import igraciarena.poc.msinvoices.utils.StubFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateInvoiceServiceTest implements StubFactory {

    @Mock
    InvoiceRepository invoiceRepository;

    CreateInvoiceService createInvoiceService;

    CreateInvoiceCommand createInvoiceCommand;

    @BeforeEach
    void setUp() {
        createInvoiceService = new CreateInvoiceService(invoiceRepository);
        createInvoiceCommand = new CreateInvoiceCommand(createInvoiceDTOStub());
    }

    @Test
    void createInvoice() {
        Invoice invoiceStub = createInvoiceStub();
        ArgumentCaptor<Invoice> argumentCaptor = ArgumentCaptor.forClass(Invoice.class);

        createInvoiceService.createInvoice(createInvoiceCommand);

        verify(invoiceRepository, times(1)).save(argumentCaptor.capture());
        Invoice invoice = argumentCaptor.getValue();

        assertEquals(invoiceStub.getCustomerId(), invoice.getCustomerId());
        assertEquals(invoiceStub.getDescription(), invoice.getDescription());
        assertEquals(invoiceStub.getNumberInvoice(), invoice.getNumberInvoice());
    }
}