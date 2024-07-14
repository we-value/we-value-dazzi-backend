package weval.dazzi.api.entity.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weval.dazzi.domain.entity.product.Product;

public class RequestProduct {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateProduct {
        private Long sellerId;
        private String title;
        private String description;
        private Double price;

        public Product toEntity() {
            return Product.builder()
                    .title(this.title)
                    .description(this.description)
                    .price(this.price)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateProduct {
        private Long sellerId;
        private Long productId;
        private String title;
        private Double price;
        private String description;
    }
}
