package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Customer;
import igraciarena.poc.mscustomers.adapters.output.dbentities.Region;
import igraciarena.poc.mscustomers.adapters.output.persistance.CustomerRepository;
import igraciarena.poc.mscustomers.adapters.output.persistance.RegionRepository;
import igraciarena.poc.mscustomers.exceptions.NotFoundException;
import igraciarena.poc.mscustomers.input.UpdateCustomerUseCase;
import igraciarena.poc.mscustomers.input.commands.UpdateCustomerCommand;
import igraciarena.poc.mscustomers.domain.mappers.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateCustomerService implements UpdateCustomerUseCase {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    private final RegionRepository regionRepository;


    @Override
    public void updateCustomer(UpdateCustomerCommand updateCustomerCommand) {
        Region region = regionRepository.findById(updateCustomerCommand.getRegionId())
                .orElseThrow(() -> new NotFoundException("The region with the id " +
                        updateCustomerCommand.getRegionId() + "has not been found"));

        Customer customer = customerRepository.findById(updateCustomerCommand.getCustomerId())
                .orElseThrow(() -> new NotFoundException("The customer with the id " +
                        updateCustomerCommand.getCustomerId() + "has not been found"));

        customer.setFirstName(updateCustomerCommand.getFirstName());
        customer.setLastName(updateCustomerCommand.getLastName());
        customer.setEmail(updateCustomerCommand.getEmail());
        customer.setRegion(region);

        customerRepository.save(customer);
    }
}
