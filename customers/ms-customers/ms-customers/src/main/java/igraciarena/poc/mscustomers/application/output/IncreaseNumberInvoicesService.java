package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Customer;
import igraciarena.poc.mscustomers.adapters.output.persistance.CustomerRepository;
import igraciarena.poc.mscustomers.application.exceptions.NotFoundException;
import igraciarena.poc.mscustomers.application.input.IncreaseNumberInvoicesUseCase;
import igraciarena.poc.mscustomers.application.input.commands.IncreaseNumberInvoicesCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IncreaseNumberInvoicesService implements IncreaseNumberInvoicesUseCase {

    private final CustomerRepository customerRepository;

    @Override
    public void increaseNumberInvoices(IncreaseNumberInvoicesCommand increaseNumberInvoicesCommand) {
        Customer customer = customerRepository.findById(increaseNumberInvoicesCommand.getCustomerId())
                .orElseThrow(() -> new NotFoundException("The customer with the id " +
                        increaseNumberInvoicesCommand.getCustomerId() + "has not been found"));

        int numberInvoices = customer.getNumberInvoices();

        customer.setNumberInvoices(numberInvoices + 1);

        customerRepository.save(customer);
    }
}
