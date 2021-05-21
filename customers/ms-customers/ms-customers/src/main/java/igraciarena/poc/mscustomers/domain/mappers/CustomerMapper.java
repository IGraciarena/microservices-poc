package igraciarena.poc.mscustomers.domain.mappers;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Customer;
import igraciarena.poc.mscustomers.input.commands.CreateCustomerCommand;
import igraciarena.poc.mscustomers.domain.dtos.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "region.id", ignore = true)
    Customer createCustomerCommandToCustomer(CreateCustomerCommand createCustomerCommand);

    @Mapping(target = "regionId", source = "region.id")
    CustomerResponse customerToCustomerResponse(Customer customer);
}
