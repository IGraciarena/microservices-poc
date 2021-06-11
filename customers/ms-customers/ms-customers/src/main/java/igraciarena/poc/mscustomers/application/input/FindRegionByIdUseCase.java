package igraciarena.poc.mscustomers.application.input;


import igraciarena.poc.mscustomers.application.input.querys.FindRegionByIdQuery;
import igraciarena.poc.mscustomers.domain.dtos.RegionResponse;

public interface FindRegionByIdUseCase {

    RegionResponse findRegionById(FindRegionByIdQuery findRegionByIdQuery);
}
