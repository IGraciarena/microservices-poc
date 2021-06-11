package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Customer;
import igraciarena.poc.mscustomers.adapters.output.persistance.CustomerRepository;
import igraciarena.poc.mscustomers.domain.dtos.CustomerResponse;
import igraciarena.poc.mscustomers.application.input.querys.FindCustomerByIdQuery;
import igraciarena.poc.mscustomers.utils.StubFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindCustomerByIdServiceTest implements StubFactory {

    @Mock
    CustomerRepository customerRepository;

    FindCustomerByIdService findCustomerByIdService;

    FindCustomerByIdQuery findCustomerByIdQuery;

    @BeforeEach
    void setUp() {
        findCustomerByIdService = new FindCustomerByIdService(customerRepository);
        findCustomerByIdQuery = new FindCustomerByIdQuery(1L);
    }

    @Test
    void findCustomerById() {
        Customer customerStub = createCustomerStub();
        Mockito.when(customerRepository.findById(anyLong())).thenReturn(Optional.of(createCustomerStub()));

        CustomerResponse customerResponse = findCustomerByIdService.findCustomerById(findCustomerByIdQuery);

        verify(customerRepository, times(1)).findById(anyLong());
        assertEquals(customerStub.getId(), customerResponse.getId());
    }
}