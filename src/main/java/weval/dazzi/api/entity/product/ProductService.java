package weval.dazzi.api.entity.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weval.dazzi.api.entity.product.dto.RequestProduct;
import weval.dazzi.api.entity.product.dto.ResponseProduct;
import weval.dazzi.domain.entity.product.Product;
import weval.dazzi.domain.entity.product.acess.jpa.ProductRepository;
import weval.dazzi.domain.entity.product.acess.querydsl.ProductQuery;
import weval.dazzi.domain.entity.seller.Seller;
import weval.dazzi.domain.entity.seller.access.jpa.SellerRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductQuery productQuery;

    private final SellerRepository sellerRepository;

    public ResponseProduct.ProductAllInfo productInfo(Long productInfo) {
        Optional<Product> findProduct = productRepository.findById(productInfo);

        findProduct.orElseThrow(
                () -> new IllegalStateException("상품을 찾을 수 없습니다.")
        );

        return productQuery.findByProduct(productInfo);
    }

    public ResponseProduct.ProductIdInfo createProduct(RequestProduct.CreateProduct createProduct) {
        Optional<Seller> findSeller = sellerRepository.findById(createProduct.getSellerId());

        Seller seller = findSeller.orElseThrow(
                () -> new IllegalStateException("판매자를 찾을 수 없습니다.")
        );

        Product product = createProduct.toEntity();
        product.productToMappingSeller(seller);
        productRepository.save(product);

        return new ResponseProduct.ProductIdInfo(product.getProductId());
    }

    public ResponseProduct.ProductIdInfo updateProduct(RequestProduct.UpdateProduct updateProduct) {
        Optional<Product> findProduct = productRepository.findById(updateProduct.getProductId());

        Product product = findProduct.orElseThrow(
                () -> new IllegalStateException("상품을 찾을 수 없습니다.")
        );

        product.updateInfo(updateProduct.getTitle(), updateProduct.getDescription(), updateProduct.getPrice());
        return new ResponseProduct.ProductIdInfo(product.getProductId());
    }
}
