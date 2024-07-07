package weval.dazzi.api.entity.oauth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RequestOauth {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OauthV1 {
        @NotBlank
        private String code;
    }
}
