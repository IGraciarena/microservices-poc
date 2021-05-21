package igraciarena.poc.mscustomers.domain.mappers;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Region;
import igraciarena.poc.mscustomers.application.input.commands.CreateRegionCommand;
import igraciarena.poc.mscustomers.domain.dtos.RegionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegionMapper {

    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

    @Mapping(target = "id", ignore = true)
    Region createRegionCommandToRegion(CreateRegionCommand createRegionCommand);

    RegionResponse regionToRegionResponse(Region region);
}
