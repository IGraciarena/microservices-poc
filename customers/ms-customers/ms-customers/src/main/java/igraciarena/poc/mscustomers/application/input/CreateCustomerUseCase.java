package igraciarena.poc.mscustomers.application.input;


import igraciarena.poc.mscustomers.application.input.commands.CreateCustomerCommand;

public interface CreateCustomerUseCase {

    void createCustomer(CreateCustomerCommand createCustomerCommand);
}
