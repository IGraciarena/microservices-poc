package igraciarena.poc.mscustomers.application.input.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateRegionCommand {

    private final Long regionId;
    private final String name;

}
