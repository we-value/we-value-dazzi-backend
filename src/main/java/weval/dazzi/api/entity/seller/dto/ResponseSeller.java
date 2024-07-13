package weval.dazzi.api.entity.seller.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ResponseSeller {

    @Getter
    @NoArgsConstructor
    public static class SellerAllInfo {
        private Long id;
        private String name;
        private String introduction;

        @QueryProjection
        public SellerAllInfo(Long id, String name, String introduction) {
            this.id = id;
            this.name = name;
            this.introduction = introduction;
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SellerIdInfo {
        private Long id;
    }
}
