package weval.dazzi.domain.entity.member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weval.dazzi.domain.BaseEntity;
import weval.dazzi.domain.enums.SocialLoginType;


import static lombok.AccessLevel.*;

@Entity
@Table(name = "da_member")
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String socialId;

    private String nickname;

    private String deviceInfo;

    @Enumerated(EnumType.STRING)
    private SocialLoginType socialLoginType;

//    @OneToOne(mappedBy = "member") //Seller.class의 member 가 주인이다. 여기의 seller는 읽기만 가능하다.
//    private Seller seller;

//    @OneToMany(mappedBy = "member")
//    private List<Order> order = new ArrayList<>();

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
