package igraciarena.poc.mscustomers.application.input;


import igraciarena.poc.mscustomers.application.input.querys.FindCustomerByIdQuery;
import igraciarena.poc.mscustomers.domain.dtos.CustomerResponse;

public interface FindCustomerByIdUseCase {

    CustomerResponse findCustomerById(FindCustomerByIdQuery findCustomerByIdQuery);
}
