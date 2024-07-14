package weval.dazzi.domain.entity.seller;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weval.dazzi.domain.BaseEntity;
import weval.dazzi.domain.entity.member.Member;
import weval.dazzi.domain.entity.product.Product;

import java.util.ArrayList;
import java.util.List;

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

    @Column(length = 500)
    private String introduction;

    @OneToOne(mappedBy = "seller", fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    List<Product> products = new ArrayList<>();

    @Builder
    public Seller(String name, String introduction, Member member) {
        this.name = name;
        this.introduction = introduction;
        this.member = member;
    }

    public void productToMappingSeller(Product product) {
        this.getProducts().add(product);
    }

    public void memberToMappingSeller(Member member) {
        this.member = member;
    }

    public void updateInfo(String name, String introduction) {
        this.name = name;
        this.introduction = introduction;
    }
}
