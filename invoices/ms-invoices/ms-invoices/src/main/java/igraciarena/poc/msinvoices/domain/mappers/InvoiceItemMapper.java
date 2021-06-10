package igraciarena.poc.msinvoices.domain.mappers;


import igraciarena.poc.msinvoices.adapters.output.dbentities.InvoiceItem;
import igraciarena.poc.msinvoices.domain.dtos.InvoiceItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InvoiceItemMapper {

    InvoiceItemMapper INSTANCE = Mappers.getMapper(InvoiceItemMapper.class);

    @Mapping(target = "quantity", source = "quantity.quantity")
    @Mapping(target = "price", source = "price.price")
    @Mapping(target = "invoiceId", source = "invoice.id")
    InvoiceItemResponse invoiceItemToInvoiceItemResponse(InvoiceItem invoiceItem);
}
