package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Customer;
import igraciarena.poc.mscustomers.adapters.output.dbentities.Region;
import igraciarena.poc.mscustomers.adapters.output.persistance.CustomerRepository;
import igraciarena.poc.mscustomers.adapters.output.persistance.RegionRepository;
import igraciarena.poc.mscustomers.application.exceptions.NotFoundException;
import igraciarena.poc.mscustomers.application.input.CreateCustomerUseCase;
import igraciarena.poc.mscustomers.application.input.commands.CreateCustomerCommand;
import igraciarena.poc.mscustomers.domain.mappers.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCustomerService implements CreateCustomerUseCase {

    private final CustomerRepository customerRepository;
    private final RegionRepository regionRepository;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;


    @Override
    public void createCustomer(CreateCustomerCommand createCustomerCommand) {
        Region region = regionRepository.findById(createCustomerCommand.getRegionId())
                .orElseThrow(() -> new NotFoundException("The region with the id " +
                        createCustomerCommand.getRegionId() + "has not been found"));

        Customer customer = customerMapper.createCustomerCommandToCustomer(createCustomerCommand);

        customer.setRegion(region);

        customerRepository.save(customer);

    }
}
