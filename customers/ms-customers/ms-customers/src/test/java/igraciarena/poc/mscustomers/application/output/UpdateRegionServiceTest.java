package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Region;
import igraciarena.poc.mscustomers.adapters.output.persistance.RegionRepository;
import igraciarena.poc.mscustomers.input.commands.UpdateRegionCommand;
import igraciarena.poc.mscustomers.utils.StubFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateRegionServiceTest implements StubFactory {

    @Mock
    RegionRepository regionRepository;

    UpdateRegionService updateRegionService;

    UpdateRegionCommand updateRegionCommand;

    @BeforeEach
    void setUp() {
        updateRegionService = new UpdateRegionService(regionRepository);
        updateRegionCommand = new UpdateRegionCommand(1L, "stub_name");
    }

    @Test
    void updateRegionUseCase() {
        Region regionStub = createRegionStub();
        when(regionRepository.findById(anyLong())).thenReturn(Optional.of(createRegionStub()));

        ArgumentCaptor<Region> argumentCaptor = ArgumentCaptor.forClass(Region.class);

        updateRegionService.updateRegionUseCase(updateRegionCommand);

        verify(regionRepository, times(1)).findById(anyLong());
        verify(regionRepository, times(1)).save(argumentCaptor.capture());

        Region region = argumentCaptor.getValue();
        assertEquals(regionStub.getName(), region.getName());
    }
}