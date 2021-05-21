package igraciarena.poc.mscustomers.input;


import igraciarena.poc.mscustomers.input.commands.UpdateCustomerCommand;

public interface UpdateCustomerUseCase {

    void updateCustomer(UpdateCustomerCommand updateCustomerCommand);
}
