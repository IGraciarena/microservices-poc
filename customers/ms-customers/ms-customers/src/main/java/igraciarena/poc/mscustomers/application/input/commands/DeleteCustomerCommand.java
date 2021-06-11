package igraciarena.poc.mscustomers.application.input.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteCustomerCommand {

    private final Long customerId;
}
