package igraciarena.poc.mscustomers.application.output;

import igraciarena.poc.mscustomers.adapters.output.dbentities.Region;
import igraciarena.poc.mscustomers.adapters.output.persistance.RegionRepository;
import igraciarena.poc.mscustomers.domain.dtos.RegionResponse;
import igraciarena.poc.mscustomers.input.querys.FindRegionByIdQuery;
import igraciarena.poc.mscustomers.utils.StubFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindRegionByIdServiceTest implements StubFactory {

    @Mock
    RegionRepository regionRepository;

    FindRegionByIdService findRegionByIdService;

    FindRegionByIdQuery findRegionByIdQuery;

    @BeforeEach
    void setUp() {
        findRegionByIdService = new FindRegionByIdService(regionRepository);
        findRegionByIdQuery = new FindRegionByIdQuery(1L);
    }

    @Test
    void findRegionById() {
        Region regionStub = createRegionStub();
        when(regionRepository.findById(anyLong())).thenReturn(Optional.of(createRegionStub()));

        RegionResponse regionResponse = findRegionByIdService.findRegionById(findRegionByIdQuery);

        verify(regionRepository, times(1)).findById(anyLong());
        assertEquals(regionStub.getId(), regionResponse.getId());
        assertEquals(regionStub.getName(), regionResponse.getName());
    }
}