package igraciarena.poc.mscustomers.adapters.input;

import igraciarena.poc.mscustomers.domain.dtos.*;
import igraciarena.poc.mscustomers.input.*;
import igraciarena.poc.mscustomers.input.commands.CreateCustomerCommand;
import igraciarena.poc.mscustomers.input.commands.DeleteCustomerCommand;
import igraciarena.poc.mscustomers.input.commands.UpdateCustomerCommand;
import igraciarena.poc.mscustomers.input.querys.FindCustomerByIdQuery;
import igraciarena.poc.mscustomers.input.querys.FindInvoicesByCustomerIdQuery;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final FindInvoicesByCustomerIdUseCase findInvoicesByCustomerIdUseCase;
    private final CreateCustomerUseCase createCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;

    @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponse> findById(@PathVariable("customerId") Long customerId) {

        FindCustomerByIdQuery findCustomerByIdQuery = new FindCustomerByIdQuery(customerId);

        return ResponseEntity.ok(findCustomerByIdUseCase.findCustomerById(findCustomerByIdQuery));
    }

    @GetMapping(value = "invoices/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InvoiceDTO>> getInvoicesByCustomerId(@PathVariable("customerId") Long customerId) {
        FindInvoicesByCustomerIdQuery findInvoicesByCustomerIdQuery = new FindInvoicesByCustomerIdQuery(customerId);

        return ResponseEntity.ok(findInvoicesByCustomerIdUseCase.findInvoicesByCustomerId(findInvoicesByCustomerIdQuery));
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {

        CreateCustomerCommand createCustomerCommand = new CreateCustomerCommand(customerDTO);

        createCustomerUseCase.createCustomer(createCustomerCommand);

        return ResponseEntity.ok().build();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCustomer(@Valid @RequestBody CustomerDTO customerDTO,
                                               @RequestParam("customerId") Long customerId) {

        UpdateCustomerCommand updateCustomerCommand = new UpdateCustomerCommand(customerId, customerDTO);

        updateCustomerUseCase.updateCustomer(updateCustomerCommand);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCustomer(@RequestParam("customerId") Long customerId) {

        DeleteCustomerCommand deleteCustomerCommand = new DeleteCustomerCommand(customerId);

        deleteCustomerUseCase.deleteCustomer(deleteCustomerCommand);

        return ResponseEntity.ok().build();
    }

}
