package igraciarena.poc.mscustomers.input;


import igraciarena.poc.mscustomers.input.querys.FindRegionByIdQuery;
import igraciarena.poc.mscustomers.domain.dtos.RegionResponse;

public interface FindRegionByIdUseCase {

    RegionResponse findRegionById(FindRegionByIdQuery findRegionByIdQuery);
}
