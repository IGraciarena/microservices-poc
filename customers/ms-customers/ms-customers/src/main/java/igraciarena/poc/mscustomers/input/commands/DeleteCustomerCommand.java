package igraciarena.poc.mscustomers.input.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteCustomerCommand {

    private final Long customerId;
}
