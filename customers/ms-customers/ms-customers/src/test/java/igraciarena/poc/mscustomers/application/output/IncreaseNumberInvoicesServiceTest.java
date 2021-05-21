package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Customer;
import igraciarena.poc.mscustomers.adapters.output.persistance.CustomerRepository;
import igraciarena.poc.mscustomers.input.commands.IncreaseNumberInvoicesCommand;
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
class IncreaseNumberInvoicesServiceTest implements StubFactory {

    @Mock
    CustomerRepository customerRepository;

    IncreaseNumberInvoicesService increaseNumberInvoicesService;

    IncreaseNumberInvoicesCommand increaseNumberInvoicesCommand;

    @BeforeEach
    void setUp() {
        increaseNumberInvoicesService = new IncreaseNumberInvoicesService(customerRepository);
        increaseNumberInvoicesCommand = new IncreaseNumberInvoicesCommand(1L);
    }

    @Test
    void increaseNumberInvoices() {
        Customer customerStub = createCustomerStub();
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(createCustomerStub()));
        ArgumentCaptor<Customer> argumentCaptor = ArgumentCaptor.forClass(Customer.class);

        increaseNumberInvoicesService.increaseNumberInvoices(increaseNumberInvoicesCommand);

        verify(customerRepository, times(1)).findById(anyLong());
        verify(customerRepository, times(1)).save(argumentCaptor.capture());

        Customer customer = argumentCaptor.getValue();
        assertEquals(customerStub.getId(), customer.getId());
        assertEquals(customerStub.getFirstName(), customer.getFirstName());
    }


}