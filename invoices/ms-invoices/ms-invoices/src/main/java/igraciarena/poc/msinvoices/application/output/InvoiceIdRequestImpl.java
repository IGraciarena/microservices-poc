package igraciarena.poc.msinvoices.application.output;

import igraciarena.poc.msinvoices.application.input.GetInvoicesByCustomerIdUseCase;
import igraciarena.poc.msinvoices.application.input.querys.GetInvoicesByCustomerIdQuery;
import igraciarena.poc.proto.CustomerId;
import igraciarena.poc.proto.Invoice;
import igraciarena.poc.proto.InvoiceServiceGrpc;
import igraciarena.poc.proto.Invoices;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GrpcService
@Slf4j
public class InvoiceIdRequestImpl extends InvoiceServiceGrpc.InvoiceServiceImplBase {

    @Autowired
    GetInvoicesByCustomerIdUseCase useCase;

    @Override
    public void invoices(CustomerId request, StreamObserver<Invoices> responseObserver) {
        log.info("server received {}", request);
        Long customerId = request.getCustomerId();

        GetInvoicesByCustomerIdQuery getInvoicesByCustomerIdQuery = new GetInvoicesByCustomerIdQuery(customerId);

        List<Invoice> invoices = useCase.getInvoicesByCustomerId(getInvoicesByCustomerIdQuery);

        Invoices response = Invoices.newBuilder()
                .addAllInvoice(invoices)
                .build();

        log.info("server responded {}", response);

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
