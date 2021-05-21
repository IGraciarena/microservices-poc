package igraciarena.poc.mscustomers.input;


import igraciarena.poc.mscustomers.input.commands.IncreaseNumberInvoicesCommand;

public interface IncreaseNumberInvoicesUseCase {

    void increaseNumberInvoices(IncreaseNumberInvoicesCommand increaseNumberInvoicesCommand);
}
