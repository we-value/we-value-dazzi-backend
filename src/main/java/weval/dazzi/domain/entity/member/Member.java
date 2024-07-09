package weval.dazzi.domain.entity.member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weval.dazzi.domain.BaseEntity;
import weval.dazzi.domain.entity.seller.Seller;
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

    /**
     * Member 주인
     * 1:1이 변경이 되지 않는다는 가정으로 Member에 Seller를 넣어두고 없으면 null 넣음.
     * Seller 주인
     * 추 후에 Member를 가지고 Seller를 찾으려면 조회를 한번 더 해야함.
     * 또, LAZY가 어쩌고 저쩌고..
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

//    @OneToMany(mappedBy = "member") //seller는 읽기만 가능하다.(주인x), 보통 수정이 이루어지는 쪽이 주인.
//    private List<Order> order = new ArrayList<>();

    @Builder
    public Member(String socialId, String nickname, SocialLoginType socialLoginType, String deviceInfo) {
        this.socialId = socialId;
        this.nickname = nickname;
        this.socialLoginType = socialLoginType;
        this.deviceInfo = deviceInfo;
    }
}
