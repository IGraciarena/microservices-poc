package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Region;
import igraciarena.poc.mscustomers.adapters.output.persistance.RegionRepository;
import igraciarena.poc.mscustomers.exceptions.NotFoundException;
import igraciarena.poc.mscustomers.input.UpdateRegionUseCase;
import igraciarena.poc.mscustomers.input.commands.UpdateRegionCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateRegionService implements UpdateRegionUseCase {

    private final RegionRepository regionRepository;

    @Override
    public void updateRegionUseCase(UpdateRegionCommand updateRegionCommand) {
        Region region = regionRepository.findById(updateRegionCommand.getRegionId())
                .orElseThrow(() -> new NotFoundException("The region with the id " +
                        updateRegionCommand.getRegionId() + "has not been found"));

        region.setName(updateRegionCommand.getName());

        regionRepository.save(region);

    }
}
