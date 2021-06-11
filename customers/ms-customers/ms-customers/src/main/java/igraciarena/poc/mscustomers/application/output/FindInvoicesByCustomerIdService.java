package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.application.input.FindInvoicesByCustomerIdUseCase;
import igraciarena.poc.mscustomers.application.input.querys.FindInvoicesByCustomerIdQuery;
import igraciarena.poc.mscustomers.domain.dtos.InvoiceDTO;
import igraciarena.poc.proto.CustomerId;
import igraciarena.poc.proto.InvoiceServiceGrpc;
import igraciarena.poc.proto.Invoices;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class FindInvoicesByCustomerIdService implements FindInvoicesByCustomerIdUseCase {


    @Override
    public List<InvoiceDTO> findInvoicesByCustomerId(FindInvoicesByCustomerIdQuery findInvoicesByCustomerIdQuery) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9999)
                .usePlaintext()
                .build();

        InvoiceServiceGrpc.InvoiceServiceBlockingStub stub = InvoiceServiceGrpc.newBlockingStub(channel);
        Invoices response = stub.invoices(CustomerId.newBuilder()
                .setCustomerId(findInvoicesByCustomerIdQuery.getCustomerId())
                .build());
        channel.shutdown();

        return response.getInvoiceList().stream()
                .map(invoice ->
                        InvoiceDTO.builder()
                                .invoiceId(invoice.getInvoiceId())
                                .price(invoice.getTotal())
                                .createAt(invoice.getCreateAt())
                                .build())
                .collect(Collectors.toList());
    }
}
