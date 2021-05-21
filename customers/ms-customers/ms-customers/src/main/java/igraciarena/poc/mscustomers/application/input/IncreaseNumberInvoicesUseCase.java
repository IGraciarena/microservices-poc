package igraciarena.poc.mscustomers.application.input;


import igraciarena.poc.mscustomers.application.input.commands.IncreaseNumberInvoicesCommand;

public interface IncreaseNumberInvoicesUseCase {

    void increaseNumberInvoices(IncreaseNumberInvoicesCommand increaseNumberInvoicesCommand);
}
