package weval.dazzi.domain.member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weval.dazzi.domain.BaseEntity;
import weval.dazzi.domain.enums.SocialLoginType;

import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member extends BaseEntity {

    private String socialId;
    private String nickname;
    @Enumerated(EnumType.STRING)
    private SocialLoginType socialLoginType;
    private String deviceInfo;

    @Builder
    public Member(String socialId, String nickname, SocialLoginType socialLoginType, String deviceInfo) {
        this.socialId = socialId;
        this.nickname = nickname;
        this.socialLoginType = socialLoginType;
        this.deviceInfo = deviceInfo;
    }

    public String getSocialIdAndNickname() {
        return this.socialId + this.nickname;
    }
}
