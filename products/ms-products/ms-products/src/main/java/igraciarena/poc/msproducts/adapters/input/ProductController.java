package igraciarena.poc.msproducts.adapters.input;


import igraciarena.poc.msproducts.application.input.CreateProductUseCase;
import igraciarena.poc.msproducts.application.input.DeleteProductUseCase;
import igraciarena.poc.msproducts.application.input.FindProductByIdUseCase;
import igraciarena.poc.msproducts.application.input.UpdateProductUseCase;
import igraciarena.poc.msproducts.application.input.commands.CreateProductCommand;
import igraciarena.poc.msproducts.application.input.commands.DeleteProductCommand;
import igraciarena.poc.msproducts.application.input.commands.UpdateProductCommand;
import igraciarena.poc.msproducts.application.input.querys.FindProductByIdQuery;
import igraciarena.poc.msproducts.domain.dtos.ProductDTO;
import igraciarena.poc.msproducts.domain.dtos.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final FindProductByIdUseCase findProductByIdUseCase;
    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("productId") String productId){

        FindProductByIdQuery findProductByIdQuery = new FindProductByIdQuery(productId);

        return ResponseEntity.ok( findProductByIdUseCase.findProductById(findProductByIdQuery));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@Valid @RequestBody ProductDTO productDTO){

        CreateProductCommand createProductCommand = new CreateProductCommand(productDTO);

        createProductUseCase.createProduct(createProductCommand);

        return ResponseEntity.ok().build();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> updateProduct(@Valid @RequestBody ProductDTO productDTO,
                                                         @RequestParam("productId") String productId){

        UpdateProductCommand updateProductCommand = new UpdateProductCommand(productId, productDTO);

        updateProductUseCase.updateProduct(updateProductCommand);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteProduct(@RequestParam("productId") String productId){

        DeleteProductCommand deleteProductCommand = new DeleteProductCommand(productId);

        deleteProductUseCase.deleteProduct(deleteProductCommand);

        return ResponseEntity.ok().build();
    }

}
