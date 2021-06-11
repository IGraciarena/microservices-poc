package igraciarena.poc.mscustomers.application.input;


import igraciarena.poc.mscustomers.application.input.commands.UpdateCustomerCommand;

public interface UpdateCustomerUseCase {

    void updateCustomer(UpdateCustomerCommand updateCustomerCommand);
}
