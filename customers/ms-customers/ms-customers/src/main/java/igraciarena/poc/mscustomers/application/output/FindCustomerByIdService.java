package igraciarena.poc.mscustomers.application.output;


import igraciarena.poc.mscustomers.adapters.output.dbentities.Customer;
import igraciarena.poc.mscustomers.adapters.output.persistance.CustomerRepository;
import igraciarena.poc.mscustomers.exceptions.NotFoundException;
import igraciarena.poc.mscustomers.input.FindCustomerByIdUseCase;
import igraciarena.poc.mscustomers.input.querys.FindCustomerByIdQuery;
import igraciarena.poc.mscustomers.domain.dtos.CustomerResponse;
import igraciarena.poc.mscustomers.domain.mappers.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindCustomerByIdService implements FindCustomerByIdUseCase {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;


    @Override
    public CustomerResponse findCustomerById(FindCustomerByIdQuery findCustomerByIdQuery) {
        Customer customer = customerRepository.findById(findCustomerByIdQuery.getCustomerId())
                .orElseThrow(() -> new NotFoundException("The customer with the id " +
                        findCustomerByIdQuery.getCustomerId() + "has not been found"));

        return customerMapper.customerToCustomerResponse(customer);

    }
}
