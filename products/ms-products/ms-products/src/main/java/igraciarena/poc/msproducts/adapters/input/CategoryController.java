package igraciarena.poc.msproducts.adapters.input;


import igraciarena.poc.msproducts.application.input.CreateCategoryUseCase;
import igraciarena.poc.msproducts.application.input.DeleteCategoryUseCase;
import igraciarena.poc.msproducts.application.input.FindCategoryByIdUseCase;
import igraciarena.poc.msproducts.application.input.UpdateCategoryUseCase;
import igraciarena.poc.msproducts.application.input.commands.CreateCategoryCommand;
import igraciarena.poc.msproducts.application.input.commands.DeleteCategoryCommand;
import igraciarena.poc.msproducts.application.input.commands.UpdateCategoryCommand;
import igraciarena.poc.msproducts.application.input.querys.FindCategoryByIdQuery;
import igraciarena.poc.msproducts.domain.dtos.CategoryDTO;
import igraciarena.poc.msproducts.domain.dtos.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final FindCategoryByIdUseCase findCategoryByIdUseCase;
    private final CreateCategoryUseCase createCategoryUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;


    @GetMapping(value = "/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable("categoryId") String categoryId){

        FindCategoryByIdQuery findCategoryByIdQuery = new FindCategoryByIdQuery(categoryId);

        return ResponseEntity.ok(findCategoryByIdUseCase.findCategoryById(findCategoryByIdQuery));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){

        CreateCategoryCommand createCategoryCommand = new CreateCategoryCommand(categoryDTO);

        createCategoryUseCase.createCategory(createCategoryCommand);

        return ResponseEntity.ok().build();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryResponse> updateCategoryName(@RequestParam("categoryId") String categoryId,
                                                               @RequestParam("categoryName") String categoryName){

        UpdateCategoryCommand updateCategoryCommand = new UpdateCategoryCommand(categoryId, categoryName);

        updateCategoryUseCase.updateCategory(updateCategoryCommand);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCategory(@RequestParam("categoryId") String categoryId){

        DeleteCategoryCommand deleteCategoryCommand = new DeleteCategoryCommand(categoryId);

        deleteCategoryUseCase.deleteCategory(deleteCategoryCommand);

        return ResponseEntity.ok().build();
    }
}
