package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Customer;
import igraciarena.poc.mscustomers.adapters.output.persistance.CustomerRepository;
import igraciarena.poc.mscustomers.adapters.output.persistance.RegionRepository;
import igraciarena.poc.mscustomers.application.input.commands.UpdateCustomerCommand;
import igraciarena.poc.mscustomers.utils.StubFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateCustomerServiceTest implements StubFactory {

    @Mock
    CustomerRepository customerRepository;

    @Mock
    RegionRepository regionRepository;

    UpdateCustomerService updateCustomerService;

    UpdateCustomerCommand updateCustomerCommand;

    @BeforeEach
    void setUp() {
        updateCustomerService = new UpdateCustomerService(customerRepository, regionRepository);
        updateCustomerCommand = new UpdateCustomerCommand(1L,createCustomerDTOStub());
    }

    @Test
    void updateCustomer() {
        Customer customerStub = createCustomerStub();
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(createCustomerStub()));
        when(regionRepository.findById(anyLong())).thenReturn(Optional.of(createRegionStub()));

        ArgumentCaptor<Customer> argumentCaptor = ArgumentCaptor.forClass(Customer.class);

        updateCustomerService.updateCustomer(updateCustomerCommand);

        verify(customerRepository, times(1)).findById(anyLong());
        verify(regionRepository, times(1)).findById(anyLong());
        verify(customerRepository, times(1)).save(argumentCaptor.capture());

        Customer customer = argumentCaptor.getValue();
        assertEquals(customerStub.getFirstName(), customer.getFirstName());
        assertEquals(customerStub.getRegion().getId(), customer.getRegion().getId());
        assertEquals(customerStub.getRegion().getName(), customer.getRegion().getName());
    }

}