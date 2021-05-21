package igraciarena.poc.mscustomers.application.input;


import igraciarena.poc.mscustomers.application.input.commands.CreateRegionCommand;

public interface CreateRegionUseCase {

    void createRegion(CreateRegionCommand createRegionCommand);
}
