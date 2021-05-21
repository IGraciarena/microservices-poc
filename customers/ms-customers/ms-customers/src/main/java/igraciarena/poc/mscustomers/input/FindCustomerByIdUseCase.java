package igraciarena.poc.mscustomers.input;


import igraciarena.poc.mscustomers.input.querys.FindCustomerByIdQuery;
import igraciarena.poc.mscustomers.domain.dtos.CustomerResponse;

public interface FindCustomerByIdUseCase {

    CustomerResponse findCustomerById(FindCustomerByIdQuery findCustomerByIdQuery);
}
