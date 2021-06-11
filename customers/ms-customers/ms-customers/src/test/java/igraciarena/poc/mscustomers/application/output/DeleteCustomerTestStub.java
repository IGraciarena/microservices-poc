package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Customer;
import igraciarena.poc.mscustomers.adapters.output.persistance.CustomerRepository;
import igraciarena.poc.mscustomers.application.input.commands.DeleteCustomerCommand;
import igraciarena.poc.mscustomers.utils.StubFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteCustomerTestStub implements StubFactory {

    @Mock
    CustomerRepository customerRepository;

    DeleteCustomerService deleteCustomerService;

    DeleteCustomerCommand deleteCustomerCommand;

    @BeforeEach
    void setUp() {
        deleteCustomerService = new DeleteCustomerService(customerRepository);
        deleteCustomerCommand = new DeleteCustomerCommand(1L);
    }

    @Test
    void deleteCustomer() {
        Customer customerStub = createCustomerStub();
        Mockito.when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customerStub));

        deleteCustomerService.deleteCustomer(deleteCustomerCommand);

        verify(customerRepository, times(1)).findById(anyLong());
        verify(customerRepository, times(1)).delete(any());
    }

}