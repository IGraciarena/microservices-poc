package igraciarena.poc.mscustomers.application.input.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteRegionCommand {

    private final Long regionId;
}
