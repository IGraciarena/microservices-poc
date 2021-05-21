package igraciarena.poc.mscustomers.application.input.commands;

import igraciarena.poc.mscustomers.domain.dtos.CustomerDTO;
import lombok.Getter;

@Getter
public class CreateCustomerCommand {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final Long regionId;

    public CreateCustomerCommand(CustomerDTO customerDTO) {
        this.firstName = customerDTO.getFirstName();
        this.lastName = customerDTO.getLastName();
        this.email = customerDTO.getEmail();
        this.regionId = customerDTO.getRegionId();
    }

}
