package igraciarena.poc.mscustomers.input.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IncreaseNumberInvoicesCommand {

    private final Long customerId;
}
