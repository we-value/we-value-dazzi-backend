package weval.dazzi.api.entity.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weval.dazzi.domain.entity.member.Member;

import java.util.Optional;

public class ResponseMember {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IsSeller {
        private String isSeller = "N";

        public IsSeller(Optional<Member> member) {
            if (member.isPresent()) {
                if (member.get().getSeller() != null) {
                    this.isSeller = "Y";
                }
            }
        }
    }
}
