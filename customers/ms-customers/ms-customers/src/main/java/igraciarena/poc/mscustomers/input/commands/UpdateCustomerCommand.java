package igraciarena.poc.mscustomers.input.commands;

import igraciarena.poc.mscustomers.domain.dtos.CustomerDTO;
import lombok.Getter;

@Getter
public class UpdateCustomerCommand {

    private final Long customerId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Long regionId;

    public UpdateCustomerCommand(Long customerId, CustomerDTO customerDTO) {
        this.customerId = customerId;
        this.firstName = customerDTO.getFirstName();
        this.lastName = customerDTO.getLastName();
        this.email = customerDTO.getEmail();
        this.regionId = customerDTO.getRegionId();
    }

}
