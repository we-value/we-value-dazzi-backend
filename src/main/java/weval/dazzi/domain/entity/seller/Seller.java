package weval.dazzi.domain.entity.seller;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weval.dazzi.domain.BaseEntity;
import weval.dazzi.domain.entity.member.Member;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "da_seller")
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Seller extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerId;

    private String name;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

//    @OneToMany(mappedBy = "seller")
//    List<Product> products = new ArrayList<>();
}
