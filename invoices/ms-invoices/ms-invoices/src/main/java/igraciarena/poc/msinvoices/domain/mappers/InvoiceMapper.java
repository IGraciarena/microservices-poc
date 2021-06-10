package igraciarena.poc.msinvoices.domain.mappers;


import igraciarena.poc.msinvoices.adapters.output.dbentities.Invoice;
import igraciarena.poc.msinvoices.application.input.commands.CreateInvoiceCommand;
import igraciarena.poc.msinvoices.domain.dtos.InvoiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InvoiceMapper {

    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    @Mapping(target = "id", ignore = true)
    Invoice createInvoiceCommandToInvoice(CreateInvoiceCommand createInvoiceCommand);

    InvoiceResponse invoiceToInvoiceResponse(Invoice invoice);
}
