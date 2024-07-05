package weval.dazzi.domain.member;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import weval.dazzi.domain.BaseEntity;
import weval.dazzi.domain.enums.SocialLoginType;

import static lombok.AccessLevel.*;

@Entity
@NoArgsConstructor(access = PROTECTED)
public class Member extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private SocialLoginType socialLoginType;
    private String socialLoginToken;
    private String deviceInfo;
}
