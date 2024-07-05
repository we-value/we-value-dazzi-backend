package weval.dazzi.api.entity.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RequestMember {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Test {
        private Long id;
    }
}
