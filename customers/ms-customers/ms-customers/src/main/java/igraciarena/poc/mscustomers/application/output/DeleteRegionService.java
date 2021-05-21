package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Region;
import igraciarena.poc.mscustomers.adapters.output.persistance.RegionRepository;
import igraciarena.poc.mscustomers.exceptions.NotFoundException;
import igraciarena.poc.mscustomers.input.DeleteRegionUseCase;
import igraciarena.poc.mscustomers.input.commands.DeleteRegionCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteRegionService implements DeleteRegionUseCase {

    private final RegionRepository regionRepository;


    @Override
    public void deleteRegion(DeleteRegionCommand deleteRegionCommand) {
        Region region = regionRepository.findById(deleteRegionCommand.getRegionId())
                .orElseThrow(() -> new NotFoundException("The region with the id " +
                        deleteRegionCommand.getRegionId() + "has not been found"));

        regionRepository.delete(region);

    }
}
