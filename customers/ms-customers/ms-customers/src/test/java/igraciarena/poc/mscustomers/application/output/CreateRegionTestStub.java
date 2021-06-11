package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Region;
import igraciarena.poc.mscustomers.adapters.output.persistance.RegionRepository;
import igraciarena.poc.mscustomers.application.input.commands.CreateRegionCommand;
import igraciarena.poc.mscustomers.utils.StubFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateRegionTestStub implements StubFactory {

    @Mock
    RegionRepository regionRepository;

    CreateRegionService createRegionService;

    CreateRegionCommand createRegionCommand;

    @BeforeEach
    void setUp() {
        createRegionService = new CreateRegionService(regionRepository);
        createRegionCommand = new CreateRegionCommand("stub_name");
    }

    @Test
    void createRegion() {
        // arrange
        Region regionStub = createRegionStub();
        ArgumentCaptor<Region> argumentCaptor = ArgumentCaptor.forClass(Region.class);

        // act
        createRegionService.createRegion(createRegionCommand);

        // assert
        verify(regionRepository, times(1)).save(argumentCaptor.capture());

        Region region = argumentCaptor.getValue();

        assertEquals(regionStub.getName(), region.getName());
    }
}