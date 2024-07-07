package weval.dazzi.api.entity.oauth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weval.dazzi.domain.enums.SocialLoginType;
import weval.dazzi.domain.entity.member.Member;

import java.util.LinkedHashMap;

public class ResponseOauth {

    @Getter
    @NoArgsConstructor
    public static class UserInfo {
        private String id;
        private LinkedHashMap<String, Object> properties;
        public String getNickname() {
            return (String) this.properties.get("nickname");
        }

        public Member toEntity(SocialLoginType loginType) {
            return Member.builder()
                    .socialId(id)
                    .socialLoginType(loginType)
                    .nickname(getNickname())
                    .deviceInfo("")
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TokenAndNickname {
        private String token;
        private String nickname;
    }
}
