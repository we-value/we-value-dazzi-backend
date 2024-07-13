package weval.dazzi.api.entity.seller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weval.dazzi.domain.entity.seller.Seller;

public class RequestSeller {


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateSeller {
        private String name;
        private String introduction;
        @JsonIgnore
        private String token;

        public void setToken(HttpServletRequest request) {
            this.token = request.getHeader("authorizationToken").substring(7);
        }

        public Seller toEntity() {
            return Seller.builder()
                    .name(this.name)
                    .introduction(this.introduction)
                    .build();
        }
    }


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateSeller {
        private Long id;
        private String name;
        private String introduction;
    }
}
