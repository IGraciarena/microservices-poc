package igraciarena.poc.msinvoices.adapters.input;


import igraciarena.poc.msinvoices.application.exceptions.FullItemListException;
import igraciarena.poc.msinvoices.application.input.CreateInvoiceItemUseCase;
import igraciarena.poc.msinvoices.application.input.DeleteInvoiceItemUseCase;
import igraciarena.poc.msinvoices.application.input.GetInvoiceItemByIdUseCase;
import igraciarena.poc.msinvoices.application.input.UpdateInvoiceItemQuantityUseCase;
import igraciarena.poc.msinvoices.application.input.commands.CreateInvoiceItemCommand;
import igraciarena.poc.msinvoices.application.input.commands.DeleteInvoiceItemCommand;
import igraciarena.poc.msinvoices.application.input.commands.UpdateInvoiceItemQuantityCommand;
import igraciarena.poc.msinvoices.application.input.querys.GetInvoiceItemByIdQuery;
import igraciarena.poc.msinvoices.domain.dtos.InvoiceItemDTO;
import igraciarena.poc.msinvoices.domain.dtos.InvoiceItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/invoiceItems")
public class InvoiceItemController {
    
    private final CreateInvoiceItemUseCase createInvoiceItemUseCase;
    private final DeleteInvoiceItemUseCase deleteInvoiceItemUseCase;
    private final UpdateInvoiceItemQuantityUseCase updateInvoiceItemQuantityUseCase;
    private final GetInvoiceItemByIdUseCase getInvoiceItemByIdUseCase;

    @GetMapping(value = "/{invoiceItemId}/{invoiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvoiceItemResponse> findInvoiceItemById(@PathVariable("invoiceItemId") Long invoiceItemId,
                                                                   @PathVariable("invoiceId") Long invoiceId){

        GetInvoiceItemByIdQuery getInvoiceItemByIdQuery = new GetInvoiceItemByIdQuery(invoiceItemId, invoiceId);

        return ResponseEntity.ok(getInvoiceItemByIdUseCase.getInvoiceItemById(getInvoiceItemByIdQuery));
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createInvoiceItem(@Valid @RequestBody InvoiceItemDTO invoiceItemDTO) throws FullItemListException {

        CreateInvoiceItemCommand createInvoiceItemCommand = new CreateInvoiceItemCommand(invoiceItemDTO);

        createInvoiceItemUseCase.createInvoiceItem(createInvoiceItemCommand);

        return ResponseEntity.ok().build();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvoiceItemResponse> updateInvoiceItem(@Valid @RequestBody InvoiceItemDTO invoiceItemDTO,
                                                         @RequestParam("invoiceItemId") Long invoiceItemId){

        UpdateInvoiceItemQuantityCommand updateInvoiceItemQuantityCommand = new UpdateInvoiceItemQuantityCommand(invoiceItemDTO, invoiceItemId);

        updateInvoiceItemQuantityUseCase.updateInvoiceItemQuantity(updateInvoiceItemQuantityCommand);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteInvoiceItem(@RequestParam("invoiceItemId") Long invoiceItemId,
                                                  @RequestParam("invoiceId") Long invoiceId){

        DeleteInvoiceItemCommand deleteInvoiceItemCommand = new DeleteInvoiceItemCommand(invoiceId, invoiceItemId);

        deleteInvoiceItemUseCase.deleteInvoiceItem(deleteInvoiceItemCommand);

        return ResponseEntity.ok().build();
    }
}
