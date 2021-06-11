package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.persistance.RegionRepository;
import igraciarena.poc.mscustomers.application.input.CreateRegionUseCase;
import igraciarena.poc.mscustomers.application.input.commands.CreateRegionCommand;
import igraciarena.poc.mscustomers.domain.mappers.RegionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateRegionService implements CreateRegionUseCase {

    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper = RegionMapper.INSTANCE;

    @Override
    public void createRegion(CreateRegionCommand createRegionCommand) {
        regionRepository.save(regionMapper.createRegionCommandToRegion(createRegionCommand));

    }
}
