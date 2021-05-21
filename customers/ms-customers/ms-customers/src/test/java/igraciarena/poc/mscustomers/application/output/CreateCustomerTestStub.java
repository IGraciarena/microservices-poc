package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Customer;
import igraciarena.poc.mscustomers.adapters.output.persistance.CustomerRepository;
import igraciarena.poc.mscustomers.adapters.output.persistance.RegionRepository;
import igraciarena.poc.mscustomers.domain.dtos.CustomerDTO;
import igraciarena.poc.mscustomers.input.commands.CreateCustomerCommand;
import igraciarena.poc.mscustomers.utils.StubFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateCustomerTestStub implements StubFactory {

    @Mock
    CustomerRepository customerRepository;

    @Mock
    RegionRepository regionRepository;

    CreateCustomerService createCustomerService;

    CreateCustomerCommand createCustomerCommand;

    @BeforeEach
    void setUp() {
        createCustomerService = new CreateCustomerService(customerRepository, regionRepository);
        createCustomerCommand = new CreateCustomerCommand(createCustomerDTOStub());
    }

    @Test
    void createCustomer() {
        // arrange
        CustomerDTO stub = createCustomerDTOStub();

        // act
        when(regionRepository.findById(anyLong())).thenReturn(Optional.of(createRegionStub()));
        ArgumentCaptor<Customer> argumentCaptor = ArgumentCaptor.forClass(Customer.class);

        createCustomerService.createCustomer(createCustomerCommand);

        // assert
        verify(regionRepository, times(1)).findById(anyLong());
        verify(customerRepository, times(1)).save(argumentCaptor.capture());

        Customer customer = argumentCaptor.getValue();

        assertEquals(stub.getRegionId(), customer.getRegion().getId());
        assertEquals(stub.getEmail(), customer.getEmail());
        assertEquals(stub.getFirstName(), customer.getFirstName());
        assertEquals(stub.getLastName(), customer.getLastName());
    }


}