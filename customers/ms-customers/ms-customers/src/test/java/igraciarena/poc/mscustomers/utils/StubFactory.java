package igraciarena.poc.mscustomers.utils;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Customer;
import igraciarena.poc.mscustomers.adapters.output.dbentities.Region;
import igraciarena.poc.mscustomers.domain.dtos.CustomerDTO;

public interface StubFactory {

    default CustomerDTO createCustomerDTOStub (){
            return CustomerDTO.builder()
                    .regionId(1L)
                    .email("stub@email.com")
                    .firstName("stub_firstName")
                    .lastName("stub_lastName")
                    .build();
    }

    default Customer createCustomerStub(){
        return Customer.builder()
                .id(1L)
                .region(createRegionStub())
                .firstName("stub_firstName")
                .lastName("stub_lastName")
                .email("stub@email.com")
                .numberInvoices(1)
                .build();
    }

    default Region createRegionStub(){
        return Region.builder()
                .id(1L)
                .name("stub_name")
                .build();
    }
}
