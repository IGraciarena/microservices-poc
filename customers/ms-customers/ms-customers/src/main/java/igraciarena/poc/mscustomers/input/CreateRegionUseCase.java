package igraciarena.poc.mscustomers.input;


import igraciarena.poc.mscustomers.input.commands.CreateRegionCommand;

public interface CreateRegionUseCase {

    void createRegion(CreateRegionCommand createRegionCommand);
}
