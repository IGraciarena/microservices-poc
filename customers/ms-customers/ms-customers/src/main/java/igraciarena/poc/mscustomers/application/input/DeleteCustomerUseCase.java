package igraciarena.poc.mscustomers.application.input;


import igraciarena.poc.mscustomers.application.input.commands.DeleteCustomerCommand;

public interface DeleteCustomerUseCase {

    void deleteCustomer(DeleteCustomerCommand deleteCustomerCommand);
}
