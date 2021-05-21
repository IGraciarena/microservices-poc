package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.persistance.RegionRepository;
import igraciarena.poc.mscustomers.input.commands.DeleteRegionCommand;
import igraciarena.poc.mscustomers.utils.StubFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteRegionServiceTest implements StubFactory {

    @Mock
    RegionRepository regionRepository;

    DeleteRegionService deleteRegionService;

    DeleteRegionCommand deleteRegionCommand;

    @BeforeEach
    void setUp() {
        deleteRegionService = new DeleteRegionService(regionRepository);
        deleteRegionCommand = new DeleteRegionCommand(1L);
    }

    @Test
    void deleteRegion() {
        Mockito.when(regionRepository.findById(anyLong())).thenReturn(Optional.of(createRegionStub()));

        deleteRegionService.deleteRegion(deleteRegionCommand);

        verify(regionRepository, times(1)).findById(anyLong());
        verify(regionRepository, times(1)).delete(any());


    }

}