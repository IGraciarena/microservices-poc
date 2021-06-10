package igraciarena.poc.msinvoices.adapters.input;

import igraciarena.poc.msinvoices.application.input.CreateInvoiceUseCase;
import igraciarena.poc.msinvoices.application.input.DeleteInvoiceUseCase;
import igraciarena.poc.msinvoices.application.input.GetInvoiceByIdUseCase;
import igraciarena.poc.msinvoices.application.input.UpdateInvoiceUseCase;
import igraciarena.poc.msinvoices.application.input.commands.CreateInvoiceCommand;
import igraciarena.poc.msinvoices.application.input.commands.DeleteInvoiceCommand;
import igraciarena.poc.msinvoices.application.input.commands.UpdateInvoiceCommand;
import igraciarena.poc.msinvoices.application.input.querys.GetInvoiceByIdQuery;
import igraciarena.poc.msinvoices.domain.dtos.InvoiceDTO;
import igraciarena.poc.msinvoices.domain.dtos.InvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@AllArgsConstructor
@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final CreateInvoiceUseCase createInvoiceUseCase;
    private final DeleteInvoiceUseCase deleteInvoiceUseCase;
    private final UpdateInvoiceUseCase updateInvoiceUseCase;
    private final GetInvoiceByIdUseCase getInvoiceByIdUseCase;

    @GetMapping(value = "/{invoiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvoiceResponse> findInvoiceById(@PathVariable("invoiceId") Long invoiceId) {

        GetInvoiceByIdQuery getInvoiceByIdQuery = new GetInvoiceByIdQuery(invoiceId);

        return ResponseEntity.ok(getInvoiceByIdUseCase.getInvoiceById(getInvoiceByIdQuery));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createInvoice(@Valid @RequestBody InvoiceDTO invoiceDTO) {

        CreateInvoiceCommand createInvoiceCommand = new CreateInvoiceCommand(invoiceDTO);

        createInvoiceUseCase.createInvoice(createInvoiceCommand);

        return ResponseEntity.ok().build();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvoiceResponse> updateInvoice(@Valid @RequestBody InvoiceDTO invoiceDTO,
                                                         @RequestParam("invoiceId") Long invoiceId) {

        UpdateInvoiceCommand updateInvoiceCommand = new UpdateInvoiceCommand(invoiceDTO, invoiceId);

        updateInvoiceUseCase.updateInvoice(updateInvoiceCommand);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteInvoice(@RequestParam("invoiceId") Long invoiceId) {

        DeleteInvoiceCommand deleteInvoiceCommand = new DeleteInvoiceCommand(invoiceId);

        deleteInvoiceUseCase.deleteInvoice(deleteInvoiceCommand);

        return ResponseEntity.ok().build();
    }
}
