package weval.dazzi.domain.entity.product;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weval.dazzi.domain.BaseEntity;
import weval.dazzi.domain.entity.seller.Seller;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "da_product")
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String title;

    @Column(length = 1000)
    private String description;

    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    //Product로 부터 Seller에 넣는다.
    public void productToMappingSeller(Seller seller) {
        this.seller = seller;
        seller.productToMappingSeller(this);
    }

    public void updateInfo(String title, String description, Double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    @Builder
    public Product(String title, String description, Double price, Seller seller) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.seller = seller;
    }


    //    @OneToMany(mappedBy = "product")
//    private List<Order> orders = new ArrayList();
}
