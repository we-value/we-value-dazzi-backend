package weval.dazzi.api.entity.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import weval.dazzi.api.entity.product.dto.RequestProduct;
import weval.dazzi.api.entity.product.dto.ResponseProduct;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseProduct.ProductAllInfo productInfo(@PathVariable("productId") String productId) {
        return productService.productInfo(Long.valueOf(productId));
    }

    @PostMapping
    public ResponseProduct.ProductIdInfo createProduct(@RequestBody RequestProduct.CreateProduct createProduct) {
        return productService.createProduct(createProduct);
    }

    @PatchMapping
    public ResponseProduct.ProductIdInfo updateProduct(@RequestBody RequestProduct.UpdateProduct updateProduct) {
        return productService.updateProduct(updateProduct);
    }
}
