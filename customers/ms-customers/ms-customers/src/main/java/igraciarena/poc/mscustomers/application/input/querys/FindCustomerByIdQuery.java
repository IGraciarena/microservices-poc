package igraciarena.poc.mscustomers.application.input.querys;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindCustomerByIdQuery {

    private final Long customerId;
}
