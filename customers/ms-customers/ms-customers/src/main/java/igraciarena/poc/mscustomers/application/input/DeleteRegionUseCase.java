package igraciarena.poc.mscustomers.application.input;


import igraciarena.poc.mscustomers.application.input.commands.DeleteRegionCommand;

public interface DeleteRegionUseCase {

    void deleteRegion(DeleteRegionCommand deleteRegionCommand);
}
