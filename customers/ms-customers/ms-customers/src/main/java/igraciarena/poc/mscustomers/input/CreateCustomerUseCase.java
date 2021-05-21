package igraciarena.poc.mscustomers.input;


import igraciarena.poc.mscustomers.input.commands.CreateCustomerCommand;

public interface CreateCustomerUseCase {

    void createCustomer(CreateCustomerCommand createCustomerCommand);
}
