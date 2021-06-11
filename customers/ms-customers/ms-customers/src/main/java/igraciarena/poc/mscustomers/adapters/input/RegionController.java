package igraciarena.poc.mscustomers.adapters.input;


import igraciarena.poc.mscustomers.domain.dtos.*;
import igraciarena.poc.mscustomers.application.input.CreateRegionUseCase;
import igraciarena.poc.mscustomers.application.input.DeleteRegionUseCase;
import igraciarena.poc.mscustomers.application.input.FindRegionByIdUseCase;
import igraciarena.poc.mscustomers.application.input.UpdateRegionUseCase;
import igraciarena.poc.mscustomers.application.input.commands.CreateRegionCommand;
import igraciarena.poc.mscustomers.application.input.commands.DeleteRegionCommand;
import igraciarena.poc.mscustomers.application.input.commands.UpdateRegionCommand;
import igraciarena.poc.mscustomers.application.input.querys.FindRegionByIdQuery;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/regions")
@AllArgsConstructor
public class RegionController {

    private final FindRegionByIdUseCase findRegionByIdUseCase;
    private final CreateRegionUseCase createRegionUseCase;
    private final DeleteRegionUseCase deleteRegionUseCase;
    private final UpdateRegionUseCase updateRegionUseCase;

    @GetMapping(value = "/{regionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegionResponse> findRegionById(@PathVariable("regionId") Long regionId) {

        FindRegionByIdQuery findRegionByIdQuery = new FindRegionByIdQuery(regionId);

        return ResponseEntity.ok(findRegionByIdUseCase.findRegionById(findRegionByIdQuery));
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRegion(@RequestParam("regionName") String regionName) {

        CreateRegionCommand createRegionCommand = new CreateRegionCommand(regionName);

        createRegionUseCase.createRegion(createRegionCommand);

        return ResponseEntity.ok().build();

    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateRegion(@RequestParam("regionName") String regionName,
                                             @RequestParam("regionId") Long regionId) {

        UpdateRegionCommand updateRegionCommand = new UpdateRegionCommand(regionId, regionName);

        updateRegionUseCase.updateRegionUseCase(updateRegionCommand);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteRegion(@RequestParam("regionId") Long regionId) {

        DeleteRegionCommand deleteRegionCommand = new DeleteRegionCommand(regionId);

        deleteRegionUseCase.deleteRegion(deleteRegionCommand);

        return ResponseEntity.ok().build();
    }


}
        