package igraciarena.poc.mscustomers.input;


import igraciarena.poc.mscustomers.input.commands.DeleteCustomerCommand;

public interface DeleteCustomerUseCase {

    void deleteCustomer(DeleteCustomerCommand deleteCustomerCommand);
}
