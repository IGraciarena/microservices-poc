package igraciarena.poc.msinvoices.utils;


import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.adapters.output.dbentities.InvoiceItem;
import igraciarena.poc.msinvoices.domain.dtos.InvoiceDTO;
import igraciarena.poc.msinvoices.domain.dtos.InvoiceItemDTO;
import igraciarena.poc.msinvoices.domain.valueObjects.Price;
import igraciarena.poc.msinvoices.domain.valueObjects.Quantity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface StubFactory {

    default Invoice createInvoiceStub() {
        return Invoice.builder()
                .id(1L)
                .numberInvoice("1")
                .description("stub_description")
                .createAt(Date.from(Instant.now()))
                .total(100D)
                .invoiceItems(new ArrayList<>())
                .customerId(1L)
                .build();
    }

    default InvoiceDTO createInvoiceDTOStub() {
        return InvoiceDTO.builder()
                .numberInvoice("1")
                .customerId(1L)
                .build();
    }

    default InvoiceItemDTO createInvoiceItemDto() {
        return InvoiceItemDTO.builder()
                .price(100D)
                .invoiceId(1L)
                .quantity(1)
                .build();
    }

    default InvoiceItem createInvoiceItemStub() {
        return InvoiceItem.builder()
                .id(1L)
                .quantity(createQuantityStub())
                .price(createPriceStub())
                .productId(1L)
                .subTotal(100D)
                .build();
    }

    default Quantity createQuantityStub() {
        return Quantity.builder()
                .quantity(1)
                .build();
    }

    default Price createPriceStub() {
        return Price.builder()
                .price(100D)
                .build();
    }
}
