package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Customer;
import igraciarena.poc.mscustomers.adapters.output.persistance.CustomerRepository;
import igraciarena.poc.mscustomers.exceptions.NotFoundException;
import igraciarena.poc.mscustomers.input.DeleteCustomerUseCase;
import igraciarena.poc.mscustomers.input.commands.DeleteCustomerCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteCustomerService implements DeleteCustomerUseCase {

    private final CustomerRepository customerRepository;


    @Override
    public void deleteCustomer(DeleteCustomerCommand deleteCustomerCommand) {
        Customer customer = customerRepository.findById(deleteCustomerCommand.getCustomerId())
                .orElseThrow(() -> new NotFoundException("The customer with the id " +
                        deleteCustomerCommand.getCustomerId() + "has not been found"));

        customerRepository.delete(customer);
    }
}
