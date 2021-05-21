package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Region;
import igraciarena.poc.mscustomers.adapters.output.persistance.RegionRepository;
import igraciarena.poc.mscustomers.exceptions.NotFoundException;
import igraciarena.poc.mscustomers.input.FindRegionByIdUseCase;
import igraciarena.poc.mscustomers.input.querys.FindRegionByIdQuery;
import igraciarena.poc.mscustomers.domain.dtos.RegionResponse;
import igraciarena.poc.mscustomers.domain.mappers.RegionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindRegionByIdService implements FindRegionByIdUseCase {

    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper = RegionMapper.INSTANCE;

    @Override
    public RegionResponse findRegionById(FindRegionByIdQuery findRegionByIdQuery) {
        Region region = regionRepository.findById(findRegionByIdQuery.getRegionId())
                .orElseThrow(() -> new NotFoundException("The region with the id " +
                        findRegionByIdQuery.getRegionId() + "has not been found"));

        return regionMapper.regionToRegionResponse(region);
    }
}
