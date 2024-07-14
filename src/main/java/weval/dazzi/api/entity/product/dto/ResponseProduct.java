package weval.dazzi.api.entity.product.dto;


import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ResponseProduct {

    @Getter
    @NoArgsConstructor
    public static class ProductAllInfo {
        private Long sellerId;
        private Long productId;
        private String title;
        private Double price;
        private String description;

        @QueryProjection
        public ProductAllInfo(Long sellerId, Long productId, String title, Double price, String description) {
            this.sellerId = sellerId;
            this.productId = productId;
            this.title = title;
            this.price = price;
            this.description = description;
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductIdInfo {
        private Long id;
    }
}
