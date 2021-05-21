package igraciarena.poc.mscustomers.input;


import igraciarena.poc.mscustomers.input.commands.DeleteRegionCommand;

public interface DeleteRegionUseCase {

    void deleteRegion(DeleteRegionCommand deleteRegionCommand);
}
